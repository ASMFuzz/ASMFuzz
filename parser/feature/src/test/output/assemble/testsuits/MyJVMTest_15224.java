import java.io.*;
import java.net.*;
import java.util.*;
import static java.util.ResourceBundle.Control.*;

public class MyJVMTest_15224 {

    static String baseName = ",#z4,Bp\"/A";

    static Properties props = null;

    List<String> getFormats(String baseName) {
        if (baseName == null) {
            throw new NullPointerException();
        }
        return Arrays.asList("xml");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15224().getFormats(baseName));
    }
}
