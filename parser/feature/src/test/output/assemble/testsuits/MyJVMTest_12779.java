import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class MyJVMTest_12779 {

    static java.io.PrintStream out = System.out;

    static boolean clientStarted = false;

    static Exception clientException = null;

    static Thread client = null;

    void startClient(final int port, final int dally) throws Exception {
        Thread t = new Thread() {

            public void run() {
                try (Socket so = new Socket()) {
                    out.println("client:  " + so);
                    clientStarted = true;
                    if (dally > 0)
                        Thread.sleep(dally);
                    so.connect(new InetSocketAddress(port));
                    if (Thread.interrupted()) {
                        out.println("client interrupted");
                        return;
                    }
                    out.println("client:  " + so);
                    int a = so.getInputStream().read();
                    out.println("client:  read " + a);
                    a += 1;
                    so.getOutputStream().write(a);
                    out.println("client:  wrote " + a);
                } catch (Exception x) {
                    if (x instanceof InterruptedException)
                        return;
                    clientException = x;
                    x.printStackTrace();
                }
            }
        };
        t.setDaemon(true);
        t.start();
        client = t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12779().run();
    }
}
