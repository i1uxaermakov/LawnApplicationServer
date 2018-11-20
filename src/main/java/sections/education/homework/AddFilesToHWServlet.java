package sections.education.homework;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import sections.education.DAO.HomeworkItemDAO;
import sections.education.DAO.SubjectItemDAO;
import sections.education.entities.HomeworkItem;
import account.entities.User;
import utils.HibernateUtil;
import utils.files.File;
import utils.files.FileUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;
import java.util.Objects;

/*
*   Maximum request size is 250 Megabytes
*   Maximum file size is 200 Megabytes
* */
@MultipartConfig(fileSizeThreshold=0, maxFileSize=1024*1024*200, maxRequestSize=1024*1024*250)
public class AddFilesToHWServlet extends HttpServlet {
    //context init parameter
    private static String pathToFiles;
    //servlet init parameter
    private static String pathSuffixForHWfiles;
    //class logger
    private static final Logger logger = LogManager.getLogger(AddFilesToHWServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session hibSession = HibernateUtil.getSessionFactory().openSession();
        User user = (User) req.getSession().getAttribute("User");
        String hwIDs = req.getParameter("hw_id");
        if(Objects.isNull(hwIDs)) {
            resp.setStatus(404);
            resp.getWriter().write("Whom is homework for?");
            return;
        }
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

        boolean isOK = homeworkItemDAO.addFileToHomeworkItemsAndUpdate(homeworkItemList,file,user.getUserId());
        if(!isOK) {
            resp.setStatus(400);
        }
        logger.info("User(userID="+user.getUserId()+") attached File(fileID="+file.getId()+") to HomeworkItems("+hwIDs.trim()+").");
        hibSession.close();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        pathToFiles = getServletContext().getInitParameter("pathToFiles");
        pathSuffixForHWfiles = getInitParameter("pathSuffixForHWfiles");
    }
}
