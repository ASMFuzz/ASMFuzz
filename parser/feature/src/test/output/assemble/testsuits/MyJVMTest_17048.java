import java.nio.channels.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.ByteBuffer;

public class MyJVMTest_17048 {

    static FileChannel fc = null;

    static Exception exception = null;

    void run() {
        ByteBuffer bb = ByteBuffer.allocate(1024);
        try {
            long pos = 0L;
            for (; ; ) {
                bb.clear();
                int n = fc.read(bb, pos);
                if (n > 0)
                    pos += n;
                if (pos >= fc.size())
                    pos = 0L;
            }
        } catch (ClosedChannelException x) {
            System.out.println(x.getClass() + " (expected)");
        } catch (Exception unexpected) {
            this.exception = unexpected;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17048().run();
    }
}
