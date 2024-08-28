import java.io.*;
import java.util.*;
import static java.util.ResourceBundle.Control.*;

public class MyJVMTest_14390 {

    static String name = "F*K{RF1.B_";

    List<String> getFormats(String name) {
        return Arrays.asList("java.class", null, "java.properties");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14390().getFormats(name));
    }
}
