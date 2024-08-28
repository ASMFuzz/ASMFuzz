import java.io.*;
import java.util.*;
import javax.annotation.processing.*;
import javax.lang.model.*;
import javax.lang.model.element.*;
import java.net.URI;

public class MyJVMTest_13849 {

    static String fParam1Param1 = "Vtuo`2\"v&;";

    static String fParam1Param2 = "v#iP2VNkzF";

    static String fParam1Param3 = "4xSs)<ccQ7";

    static URI fParam1 = new URI(fParam1Param1, fParam1Param2, fParam1Param3);

    static File f = new File(fParam1);

    static String body = "KkDl'*]z5O";

    File writeFile(File f, String body) throws Exception {
        if (f.getParentFile() != null)
            f.getParentFile().mkdirs();
        Writer out = new FileWriter(f);
        try {
            out.write(body);
        } finally {
            out.close();
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13849().writeFile(f, body);
    }
}
