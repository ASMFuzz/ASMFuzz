import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.channels.*;
import java.util.concurrent.*;

public class MyJVMTest_450 {

    void tryToDeadlock(final Channel channel, FileLock[] locks) throws IOException {
        Thread closer = new Thread(new Runnable() {

            public void run() {
                try {
                    channel.close();
                } catch (IOException ignore) {
                    ignore.printStackTrace();
                }
            }
        });
        closer.start();
        for (int i = 0; i < locks.length; i++) {
            try {
                locks[i].release();
            } catch (ClosedChannelException ignore) {
            }
        }
        while (closer.isAlive()) {
            try {
                closer.join();
            } catch (InterruptedException ignore) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_450().run();
    }
}
