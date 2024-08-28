import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

public class MyJVMTest_10550 {

    static Process p = null;

    static int exitValue = 8;

    static String stdout = "cPHw~CNYt$";

    static String stderr = "(n^q3GKJ>-";

    ProcessResults doWaitFor(Process p) {
        ProcessResults pres = new ProcessResults();
        InputStream in = null;
        InputStream err = null;
        try {
            in = p.getInputStream();
            err = p.getErrorStream();
            boolean finished = false;
            while (!finished) {
                try {
                    while (in.available() > 0) {
                        pres.stdout += (char) in.read();
                    }
                    while (err.available() > 0) {
                        pres.stderr += (char) err.read();
                    }
                    pres.exitValue = p.exitValue();
                    finished = true;
                } catch (IllegalThreadStateException e) {
                    Thread.currentThread().sleep(500);
                }
            }
            if (in != null)
                in.close();
            if (err != null)
                err.close();
        } catch (Throwable e) {
            System.err.println("doWaitFor(): unexpected exception");
            e.printStackTrace();
        }
        return pres;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10550().doWaitFor(p));
    }
}
