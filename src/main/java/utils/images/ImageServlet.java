package utils.images;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImageServlet extends HttpServlet {
    public static String pathToPhotos;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedPhoto = request.getRequestURI();
        requestedPhoto = requestedPhoto.replace("/images", "");


        //todo what is authenticate, startasync, getUserPrincipal, user in role, login(), logout(), gtPushBuilder

        //todo defaultphoto
        //todo loading while img is downloading on front

        System.out.println(requestedPhoto);
        if(requestedPhoto.equals("")) {
        }
        else {
            File image = new File(pathToPhotos + requestedPhoto);
            if(!image.exists() || image.isDirectory() || !image.getAbsolutePath().contains(pathToPhotos)) {
//                todo 404 or defaultphoto
            }
//        System.out.println("/Users/ilya_ermakov/Desktop" +reqPath);

            response.setContentType("image/jpg");
            response.setContentLength((int) image.length());

            FileInputStream fileInputStream = new FileInputStream(image);
            OutputStream outputStream = response.getOutputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(buf)) >= 0) {
                outputStream.write(buf);
            }
            fileInputStream.close();
            outputStream.close();


        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
        pathToPhotos = getServletContext().getInitParameter("pathToPhotos");
    }
}
