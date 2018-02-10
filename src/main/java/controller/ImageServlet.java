package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pathBeginning = "/Users/ilya_ermakov/Desktop/image";
        String requestURI = req.getRequestURI();
        requestURI = requestURI.replace("/image", "");

        if(requestURI.equals("")) {
            resp.setContentType("text/html");
            resp.getWriter().println("image");
        }
        else {
            File image = new File(pathBeginning + requestURI);
//        System.out.println("/Users/ilya_ermakov/Desktop" +reqPath);

            resp.setContentType("image/png");
            resp.setContentLength((int) image.length());

            FileInputStream fileInputStream = new FileInputStream(image);
            OutputStream outputStream = resp.getOutputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(buf)) >= 0) {
                outputStream.write(buf);
            }
            fileInputStream.close();
            outputStream.close();
        }
    }
}
