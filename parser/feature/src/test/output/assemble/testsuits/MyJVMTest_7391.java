import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class MyJVMTest_7391 {

    static InputStream is = null;

    static ByteArrayOutputStream os = new ByteArrayOutputStream();

    void run() {
        try {
            int i;
            while ((i = is.read()) >= 0) os.write(i);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7391().run();
    }
}
