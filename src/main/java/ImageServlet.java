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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pathBeginning = "/Users/ilya_ermakov/Desktop/images"; //todo initialization parameter
        String requestURI = request.getPathInfo();
        //requestURI = requestURI.replace("/image", "");


        if(requestURI.equals("")) {
            response.setContentType("text/html");
            response.getWriter().println("image");
        }
        else {
            File image = new File(pathBeginning + requestURI);
            if(!image.getAbsolutePath().contains(pathBeginning)) {
                //todo 404
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
}
