package utils.filemanagement;

import org.hibernate.Session;
import utils.HibernateUtil;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileDownloadingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String pathBeginning = getInitParameter("fileUploadingRoot");
//        String requestPath = request.getPathInfo();

        /*
        // reads input file from an absolute path
        File downloadFile = new File(pathBeginning + requestPath);
        FileInputStream inStream = new FileInputStream(downloadFile);

        MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap();

        // obtains ServletContext
        String mimeType = mimetypesFileTypeMap.getContentType(downloadFile);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);

        // modifies response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        // forces download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        // obtains response's output stream
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inStream.close();
        outStream.close();
        */
    }


}
