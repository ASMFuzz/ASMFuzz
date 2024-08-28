import java.io.*;
import javax.tools.*;

public class MyJVMTest_221 {

    static File b_class = new File("B.class");

    static String text = ",uP>.LTQa.";

    void create() throws IOException {
        FileOutputStream out = new FileOutputStream(b_class);
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_221().create();
    }
}
