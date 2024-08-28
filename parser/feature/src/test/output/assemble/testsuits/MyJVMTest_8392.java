import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class MyJVMTest_8392 {

    static FileChannel channel = null;

    WritableByteChannel test2(FileChannel channel) throws Exception {
        ByteArrayOutputStream istr = new ByteArrayOutputStream(4);
        WritableByteChannel wbc = Channels.newChannel(istr);
        wbc.close();
        try {
            channel.transferTo(0, 2, wbc);
            throw new Exception("Test2: No ClosedChannelException was thrown");
        } catch (ClosedChannelException cce) {
        }
        return wbc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8392().test2(channel);
    }
}
