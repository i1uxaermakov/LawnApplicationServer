package utils.files;

import org.apache.commons.io.FilenameUtils;
import security.entities.User;

import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class FileUtilities {
    public void writeFileFromInputStreamToOutputStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
    }

    public static String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    public static File processReceivedFileAndGetFileEntity(Part part, String pathToHWfiles, User user) {
        String fileName = FileUtilities.getFileName(part);
        if(part==null || fileName==null || fileName=="") {
            return null;
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

        try (OutputStream out = new FileOutputStream(new java.io.File(pathToHWfiles + java.io.File.separator + fileNameToSave + "." + FilenameUtils.getExtension(fileName)));
             InputStream fileContent = part.getInputStream()) {
            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = fileContent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        }
        catch (IOException fne) {
            fne.printStackTrace();
        }

        utils.files.File file = new utils.files.File();
        file.setLocation(pathToHWfiles + java.io.File.separator + fileNameToSave + "." + FilenameUtils.getExtension(fileName));
        file.setSize(part.getSize());
        file.setSaveName(fileNameToSave + "." + FilenameUtils.getExtension(fileName));
        file.setOriginalName(fileName);
        file.setAuthor(user.getFirstName() + " " + user.getLastName());
        file.setPublishDate(new Timestamp(System.currentTimeMillis()));

        return file;
    }
}
