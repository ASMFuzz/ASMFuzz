import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class MyJVMTest_16922 {

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
        new MyJVMTest_16922().run();
    }
}
