package sections.education.homework;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import sections.education.DAO.HomeworkItemDAO;
import sections.education.entities.HomeworkItem;
import org.apache.commons.io.FilenameUtils;
import security.entities.User;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@MultipartConfig
public class AddFilesToHWServlet extends HttpServlet {
    private static String pathToHWfiles;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session hibSession = HibernateUtil.getSessionFactory().openSession();
        User user = (User) req.getSession().getAttribute("User");
        String hwIDs = req.getParameter("hw_id");
        String[] ids = hwIDs.split(";");

        Long[] idsLong = new Long[ids.length];
        for(int i=0; i<ids.length; i++) {
            ids[i] = ids[i].trim();
            if(StringUtils.isNumeric(ids[i])) {
                idsLong[i] = new Long(ids[i]);
            }
            else {
                resp.setStatus(400);
                return;
            }
        }

        HomeworkItemDAO homeworkItemDAO = new HomeworkItemDAO();
        List<HomeworkItem> homeworkItemList = homeworkItemDAO.getHomeworkItemsForAddingFiles(idsLong);

        if(homeworkItemList.size()!=ids.length) {
            resp.setStatus(400);
            return;
        }

        Part part = req.getPart("file");
        String fileName = getFileName(part);
        if(fileName==null || fileName=="") {
            resp.setStatus(400);
            return;
        }

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update((FilenameUtils.getBaseName(fileName) + System.currentTimeMillis()).getBytes());
        byte[] digest = md.digest();
        String fileNameToSave = DatatypeConverter.printHexBinary(digest).toUpperCase();

        try (OutputStream out = new FileOutputStream(new File(pathToHWfiles + File.separator + fileNameToSave + "." + FilenameUtils.getExtension(fileName)));
             InputStream fileContent = part.getInputStream()) {
            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = fileContent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        }
        catch (FileNotFoundException fne) {
            fne.printStackTrace();
        }

        utils.filemanagement.File file = new utils.filemanagement.File();
        file.setLocation(pathToHWfiles + File.separator + fileNameToSave + "." + FilenameUtils.getExtension(fileName));
        file.setSize(part.getSize());
        file.setSaveName(fileNameToSave + "." + FilenameUtils.getExtension(fileName));
        file.setOriginalName(fileName);
        file.setAuthor(user.getFirstName() + " " + user.getLastName());
        file.setPublishDate(new Timestamp(System.currentTimeMillis()));

        hibSession.beginTransaction();
        for(HomeworkItem homeworkItem: homeworkItemList) {
            if(user.getUserId().equals(homeworkItem.getAddedById())) {
                Set<utils.filemanagement.File> set = homeworkItem.getFiles();
                set.add(file);
                homeworkItem.setFiles(set);
                hibSession.update(homeworkItem);
            }
            else{
                resp.setStatus(400);
                return;
            }
        }
        hibSession.getTransaction().commit();
        hibSession.close();
    }

    private String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    @Override
    public void init() throws ServletException {
        super.init();
        pathToHWfiles = getInitParameter("pathToHWfiles");
    }
}
