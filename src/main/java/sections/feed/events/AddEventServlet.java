package sections.feed.events;

import utils.files.FileUtilities;
import utils.HibernateUtil;
import sections.feed.events.entities.Event;
import account.entities.User;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
public class AddEventServlet extends HttpServlet {
//    private String pathBeginningForEventFiles;
    private String pathBeginningForEventPhotos;

    @Override
    public void init() throws ServletException {
        super.init();
        pathBeginningForEventPhotos = getInitParameter("pathBeginningForEventPhotos");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        //request.getRequestDispatcher("/WEB-INF/JSP/AddEventJSP.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        FileUtilities fileManager = new FileUtilities();
        User user = (User) req.getSession().getAttribute("User");
        //Date date = new Date(System.currentTimeMillis());
        String author = user.getFirstName() + " " + user.getLastName();

        Event event = new Event();
        event.setAddedBy(author);
        event.setDescription(req.getParameter("eventDescription"));
        //event.setEventDate(new Date(req.getParameter("eventDate")));
        //сравнить даты и поставить hasPassed
//        event.setHasPassed(false);
        event.setName(req.getParameter("eventName"));
        event.setVenue(req.getParameter("eventVenue"));

        session.persist(event);

//        Part filePart = req.getPart("photo");
//        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();// MSIE fix.
//        String filePath = pathBeginningForEventPhotos + "/" + event.getId() + fileName;
//        FileInputStream fileContent = (FileInputStream) filePart.getInputStream();
//        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
//        fileManager.writeFileFromInputStreamToOutputStream(fileContent, fileOutputStream);
//
//        event.setEventPhotoLocation(filePath);
        session.close();
    }
}
/*
private Long id;
    private String name;
    private String description;
    private String eventPhotoLocation;
    private Date eventDate;
    private String venue;
    private boolean hasPassed = false;
    private String addedBy;
 */