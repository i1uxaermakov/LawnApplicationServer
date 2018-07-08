package utils.filemanagement;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileManager {
    public void writeFileFromInputStreamToOutputStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
    }
}
