package model.entities;

import java.util.HashSet;
import java.util.Set;

public class File {
    private Long fileId;
    private String fileName;
    private Long fileSize;
    private String fileLocation;


    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public Long getNewsIdThatFileIsAttachedTo() {
        return newsIdThatFileIsAttachedTo;
    }

    public void setNewsIdThatFileIsAttachedTo(Long newsIdThatFileIsAttachedTo) {
        this.newsIdThatFileIsAttachedTo = newsIdThatFileIsAttachedTo;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileId=" + fileId +
                ", fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", fileLocation='" + fileLocation + '\'' +
                ", newsIdThatFileIsAttachedTo=" + newsIdThatFileIsAttachedTo +
                '}';
    }
}
