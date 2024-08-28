import java.nio.*;
import java.nio.charset.*;
import java.util.*;

public class MyJVMTest_17102 {

    static int TRIALS = 1000;

    static Charset[] charsets = new Charset[] { Charset.forName("US-ASCII"), Charset.forName("UTF-8"), Charset.forName("CP1252"), Charset.forName("UTF-16BE") };

    static boolean failed = false;

    static Random rnd = new Random(System.identityHashCode(this));

    void run() {
        for (int i = 0; i < TRIALS; i++) {
            Charset cs = charsets[rnd.nextInt(4)];
            try {
                if (rnd.nextBoolean()) {
                    cs.encode("hi mom");
                } else {
                    cs.decode(ByteBuffer.wrap(new byte[] { (byte) 'x', (byte) 'y', (byte) 'z', (byte) 'z', (byte) 'y' }));
                }
            } catch (Exception x) {
                x.printStackTrace();
                failed = true;
                return;
            }
            if (rnd.nextBoolean())
                Thread.yield();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17102().run();
    }
}
