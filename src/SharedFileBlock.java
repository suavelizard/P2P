/**
 * Created by Zane on 2014-09-29.
 */
public class SharedFileBlock {
    private byte[] blockBytes;
    private static final int blockSize = 1024;

    public static int getBlockSize() {
        return blockSize;
    }

    public SharedFileBlock(){
        //TODO: Constructor
    }
}
