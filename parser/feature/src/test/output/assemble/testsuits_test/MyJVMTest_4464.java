import java.io.*;
import java.util.*;
import javax.annotation.processing.*;
import javax.lang.model.*;
import javax.lang.model.element.*;

public class MyJVMTest_4464 {

    static String fParam1 = "6WI!b.:kZh";

    static String fParam2 = "d=)EtN2?L7";

    static File f = new File(fParam1, fParam2);

    static String body = "+$IsJ*D)pB";

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
        new MyJVMTest_4464().writeFile(f, body);
    }
}
