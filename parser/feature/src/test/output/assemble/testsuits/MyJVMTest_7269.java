import java.io.*;

public class MyJVMTest_7269 {

    static String fParam1 = "^p#WySHOh,";

    static String fParam2 = "J5'8itPhte";

    static File f = new File(fParam1, fParam2);

    File rm(File f) {
        if (!f.delete())
            throw new RuntimeException("Can't delete " + f);
        return f;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7269().rm(f);
    }
}
