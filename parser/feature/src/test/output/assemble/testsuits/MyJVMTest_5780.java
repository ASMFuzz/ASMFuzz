import java.io.*;
import java.net.*;
import java.util.*;
import static java.util.ResourceBundle.Control.*;

public class MyJVMTest_5780 {

    static String baseName = "!@}#>:\"TzW";

    static Properties props = null;

    List<String> getFormats(String baseName) {
        if (baseName == null) {
            throw new NullPointerException();
        }
        return Arrays.asList("xml");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5780().getFormats(baseName));
    }
}
