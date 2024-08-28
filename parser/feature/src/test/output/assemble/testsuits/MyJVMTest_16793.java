import java.io.*;
import java.net.URI;

public class MyJVMTest_16793 {

    static String fParam1Param1Param1Param1 = "\"gI:^O1.a_";

    static URI fParam1Param1Param1 = new URI(fParam1Param1Param1Param1);

    static File fParam1Param1 = new File(fParam1Param1Param1);

    static String fParam1Param2 = "j'Y!m3__9B";

    static File fParam1 = new File(fParam1Param1, fParam1Param2);

    static String fParam2 = "kYWXEY]PR}";

    static File f = new File(fParam1, fParam2);

    File rm(File f) {
        if (!f.delete())
            throw new RuntimeException("Can't delete " + f);
        return f;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16793().rm(f);
    }
}
