import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Zane on 2014-09-26.
 */
public class SharedFile {

    private File file;
    private String fileName;
    private String localFileLocation;
    private Long fileSize;
    private String fileHash;
    private Date FileDate;
    private List<SharedFileBlock> blocks;

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

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
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

    public SharedFile(String filePath, String fileName) {
        if (!fileName.equals(null)) {
            System.out.println(filePath + "\\" + fileName);
            this.setFileName(fileName);
            this.setLocalFileLocation(filePath);
            this.setFileDate(new Date());
            this.setFileHash(Integer.toString(this.getFileName().hashCode() + this.getLocalFileLocation().hashCode() + this.getFileDate().toString().hashCode()));
        }
        //setBlocks();

    }

    public void loadFile(){
        //This is seperate from the constructor in an attempt to save memory. Only load the file when its needed.
        this.setFile(this.localFileLocation + "\\" + this.fileName);
        this.fileSize = this.file.length();
    }

    public void setBlocks() {
        //TODO: Get file size
        //TODO: Divide into blocks
        //TODO: Loop through file adding blocks
        //TODO: Create list of block
        Long  fileSizeInBytes = this.file.length();
        Long numberOfBlocks = fileSizeInBytes / SharedFileBlock.getBlockSize();
        //This won't work. Large files will kill memory. Going to need to lazy process this
        //Check the code here instead: http://www.coderanch.com/t/433429/java/java/peer-peer-network-java
//        System.out.println("Number of Blocks in " + this.fileName + " is " + numberOfBlocks);
//        this.blocks = new ArrayList<SharedFileBlock>(numberOfBlocks+1);
//        for(int i = 1; i < numberOfBlocks; i++){
//
//        }
    }
}