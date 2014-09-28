import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by Zane on 2014-09-26.
 */
public class SharedFile {


    private File file;
    private String fileName;
    private String localFileLocation;
    private int fileSize;
    private String fileHash;
    private Date FileDate;
    private List blocks;
    public File getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = new File(file);
    }
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLocalFileLocation() {
        return localFileLocation;
    }

    public void setLocalFileLocation(String localFileLocation) {
        this.localFileLocation = localFileLocation;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileHash() {
        return fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }

    public Date getFileDate() {
        return FileDate;
    }

    public void setFileDate(Date fileDate) {
        FileDate = fileDate;
    }

    public SharedFile SharedFile(String fileName, String filePath) {
        if (!fileName.equals(null)) {
            this.setFileName(fileName);
            this.setLocalFileLocation(filePath);
            this.setFile(filePath + fileName);
        }
        this.setFileDate(new Date());
        this.setFileHash(Integer.toString(this.getFileName().hashCode() + this.getLocalFileLocation().hashCode() + this.getFileDate().toString().hashCode()));

        return this;
    }

}
