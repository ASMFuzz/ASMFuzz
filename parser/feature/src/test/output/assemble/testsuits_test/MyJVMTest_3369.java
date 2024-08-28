import com.sun.net.httpserver.*;
import java.util.*;
import java.util.concurrent.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.net.*;

public class MyJVMTest_3369 {

    static ByteBuffer buf = null;

    boolean responseComplete(ByteBuffer buf) {
        int pos = buf.position();
        buf.flip();
        byte[] lookingFor = new byte[] { '\r', '\n', '\r', '\n' };
        int lookingForCount = 0;
        while (buf.hasRemaining()) {
            byte b = buf.get();
            if (b == lookingFor[lookingForCount]) {
                lookingForCount++;
                if (lookingForCount == 4) {
                    return true;
                }
            } else {
                lookingForCount = 0;
            }
        }
        buf.position(pos);
        buf.limit(buf.capacity());
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3369().responseComplete(buf));
    }
}
