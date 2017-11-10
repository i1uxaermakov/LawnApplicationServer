package model.entities;

public class File {
    private Long fileId;
    private String fileName;
    private Long fileSize;
    private String fileLocation;
    private String fileAddedBy;

    public String getFileAddedBy() {
        return fileAddedBy;
    }

    public void setFileAddedBy(String fileAddedBy) {
        this.fileAddedBy = fileAddedBy;
    }

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

}
