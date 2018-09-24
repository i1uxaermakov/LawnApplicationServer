package utils.files;

import org.apache.commons.io.FilenameUtils;
import account.entities.User;

import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Objects;

public class FileUtilities {
    public void writeFileFromInputStreamToOutputStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
    }

    public static String getFileName(final Part part) {
        if(Objects.nonNull(part)) {
            for (String content : part.getHeader("content-disposition").split(";")) {
                if (content.trim().startsWith("filename")) {
                    return content.substring(
                            content.indexOf('=') + 1).trim().replace("\"", "");
                }
            }
        }
        return null;
    }

    public static File processReceivedFileAndGetFileEntity(Part part, String pathToHWfiles, String suffix, User user) {
        String fileName = FileUtilities.getFileName(part);
        if(part==null || fileName==null || fileName.equals("")) {
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

        try (OutputStream out = new FileOutputStream(
                new java.io.File(pathToHWfiles + java.io.File.separator + suffix + java.io.File.separator +
                                fileNameToSave + "." + FilenameUtils.getExtension(fileName)));
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
        file.setSize(part.getSize());
        file.setSaveName(suffix + java.io.File.separator + fileNameToSave + "." + FilenameUtils.getExtension(fileName));
        file.setOriginalName(fileName);
        file.setAuthor(user.getFullName());
        file.setPublishDate(new Timestamp(System.currentTimeMillis()));

        System.out.println(fileName);
        System.out.println(System.currentTimeMillis());
        System.out.println(file.getPublishDate());

        return file;
    }
}
