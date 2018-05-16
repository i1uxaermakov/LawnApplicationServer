package sections.feed.posts;

import filemanagement.FileManager;
import model.DAO.HibernateUtil;
import model.entities.File;
import sections.feed.posts.model.entities.Post;
import model.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@MultipartConfig
public class AddPostServlet extends HttpServlet {
    private String pathBeginningForPostFiles;
    private String pathBeginningForPostPhotos;

    @Override
    public void init() throws ServletException {
        super.init();
        pathBeginningForPostFiles = getInitParameter("pathBeginningForPostFiles");
        pathBeginningForPostPhotos = getInitParameter("pathBeginningForPostPhotos");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/WEB-INF/JSP/AddPostJSP.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        FileManager fileManager = new FileManager();
        User user = (User) req.getSession().getAttribute("User");
        Date date = new Date(System.currentTimeMillis());
        String author = user.getFirstName() + " " + user.getLastName();

        Post post = new Post();
        post.setAuthorName(author);
        if(!(post.getAuthorName().equals(req.getParameter("author")))) {
            if(user.getOrganizations().contains(req.getParameter("author"))) {
                post.setOrganizationName(req.getParameter("author"));
            }
        }

        post.setPostText(req.getParameter("postText"));
        post.setTitle(req.getParameter("title"));
        post.setPublishDate(date);
//        if(req.getParameter("description")==null) {
//            post.setDescription(post.getPostText().substring(0,300));
//        }
//        else {
//            post.setDescription(req.getParameter("description"));
//        }

        if(user.getPrivileges().contains("posts")) {
            post.setStatus("approved");
        }
        else {
            post.setStatus("tobechecked");
        }

        Transaction transaction = session.beginTransaction();
        session.persist(post);
        transaction.commit();

        // Retrieves <input type="file" name="file" multiple="true">
        List<Part> fileParts = req.getParts().stream().filter(part -> "files".equals(part.getName())).collect(Collectors.toList());
        Set<File> fileSet = new HashSet<>(0);
        for (Part filePart : fileParts) {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            String filePath = pathBeginningForPostFiles + "/" + post.getId().toString() + "/" + fileName;

            InputStream fileContent = filePart.getInputStream();
            OutputStream outputStream = new FileOutputStream(filePath);
            fileManager.writeFileFromInputStreamToOutputStream(fileContent, outputStream);

            fileContent.close();
            outputStream.flush();
            outputStream.close();

            File file = new File();
            file.setAuthor(author);
            file.setName(fileName);
            file.setPublishDate(date);
            file.setLocation(filePath);
            fileSet.add(file);
        }
        post.setFiles(fileSet);

//        List<Part> photoParts = req.getParts().stream().filter(part -> "photos".equals(part.getName())).collect(Collectors.toList());
//        Set<Photo> photoSet = new HashSet<>(0);
//        for(Part photoPart: photoParts) {
//            String photoName = Paths.get(photoPart.getSubmittedFileName()).getFileName().toString();
//            String photoPath = pathBeginningForPostPhotos + "/" + post.getId().toString() + "/" + "BIG" + photoName;//+ "/" + photoName
//
//            FileInputStream fileContent = (FileInputStream) photoPart.getInputStream();
//            FileOutputStream outputStream = new FileOutputStream(photoPath);
//            fileManager.writeFileFromInputStreamToOutputStream(fileContent, outputStream);
//
//            fileContent.close();
//            outputStream.flush();
//            outputStream.close();
//
//            Photo photo = new Photo();
//            photo.setPhotoName(photoName);
//            photo.setPublishDate(date);
//            photo.setAuthor(author);
//            photoSet.add(photo);
//        }
//        post.setPhotos(photoSet);

        session.close();
    }

}
/*
    private Long id;
    private String authorName;
    private String organizationName;
    private Date publishDate;
    private String title;
    private String postText;
    private String description;
    private String status;
    private Set<Photo> photos;
    private Set<Video> videos;
    private Set<File> files;
    private Set<Tag> tags;
 */