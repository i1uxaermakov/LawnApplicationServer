package utils.files;

import org.hibernate.Session;
import utils.HibernateUtil;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileDownloadingServlet extends HttpServlet {
    private static String pathToFiles;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedFile = request.getRequestURI();
        requestedFile = requestedFile.replace("/files/download/", "");

        // reads input file from an absolute path
        File downloadFile = new File(pathToFiles + File.separator + requestedFile);
        if(downloadFile.exists()) {
            FileInputStream inStream = new FileInputStream(downloadFile);

            MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap();

            // obtains ServletContext
            String mimeType = mimetypesFileTypeMap.getContentType(downloadFile);
            if (mimeType == null) {
                // set to binary type if MIME mapping not found
                mimeType = "application/octet-stream";
            }

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
        }
        else {
            response.setStatus(404);
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
        pathToFiles = getServletContext().getInitParameter("pathToFiles");
    }
}
