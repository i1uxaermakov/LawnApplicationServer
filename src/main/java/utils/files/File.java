package utils.files;

import java.sql.Timestamp;
import java.text.DecimalFormat;

public class File implements Comparable<File>{
    private Long id;
    private String originalName;
    private String saveName;
    private Long size;
    private String author;
    private Timestamp publishDate;

    public File() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String name) {
        this.originalName = name;
    }

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    public String getReadableFileSize() {
        if(this.size <= 0) return "0";
        final String[] units = new String[] { "B", "kB", "MB", "GB", "TB" };
        int digitGroups = (int) (Math.log10(this.size)/Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(this.size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    @Override
    public int compareTo(File o) {
        return this.getPublishDate().compareTo(o.getPublishDate());
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", originalName='" + originalName + '\'' +
                ", saveName='" + saveName + '\'' +
                ", size=" + size +
                ", author='" + author + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
