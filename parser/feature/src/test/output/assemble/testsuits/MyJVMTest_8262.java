import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class MyJVMTest_8262 {

    static FileChannel channel = null;

    ReadableByteChannel test1(FileChannel channel) throws Exception {
        ByteArrayInputStream istr = new ByteArrayInputStream(new byte[] { 1, 2, 3, 4 });
        ReadableByteChannel rbc = Channels.newChannel(istr);
        rbc.close();
        try {
            channel.transferFrom(rbc, 0, 2);
            throw new Exception("Test1: No ClosedChannelException was thrown");
        } catch (ClosedChannelException cce) {
        }
        return rbc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8262().test1(channel);
    }
}
