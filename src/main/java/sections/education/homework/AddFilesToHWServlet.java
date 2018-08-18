package sections.education.homework;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import sections.education.DAO.HomeworkItemDAO;
import sections.education.entities.HomeworkItem;
import org.apache.commons.io.FilenameUtils;
import security.entities.User;
import utils.HibernateUtil;
import utils.files.File;
import utils.files.FileUtilities;

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
    //context init parameter
    private static String pathToFiles;
    //servlet init parameter
    private static String pathSuffixForHWfiles;

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
        List<HomeworkItem> homeworkItemList = homeworkItemDAO.getHomeworkItemsForAddingFilesOrPhotos(idsLong);

        if(homeworkItemList.size()!=ids.length) {
            resp.setStatus(400);
            return;
        }

        Part part = req.getPart("file");
        (new java.io.File(pathToFiles + java.io.File.separator + pathSuffixForHWfiles)).mkdirs();
        File file = FileUtilities.processReceivedFileAndGetFileEntity(part, pathToFiles, pathSuffixForHWfiles, user);
        if(file==null) {
            resp.setStatus(400);
            return;
        }

        hibSession.beginTransaction();
        for(HomeworkItem homeworkItem: homeworkItemList) {
            if(user.getUserId().equals(homeworkItem.getAddedById())) {
                Set<utils.files.File> set = homeworkItem.getFiles();
                set.add(file);
                homeworkItem.setFiles(set);
                hibSession.update(homeworkItem);
            }
            else{
                hibSession.getTransaction().rollback();
                hibSession.close();
                resp.setStatus(400);
                return;
            }
        }
        hibSession.getTransaction().commit();
        hibSession.close();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        pathToFiles = getServletContext().getInitParameter("pathToFiles");
        pathSuffixForHWfiles = getInitParameter("pathSuffixForHWfiles");
    }
}
