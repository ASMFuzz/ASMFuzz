import java.io.*;
import java.net.*;
import java.util.*;
import static java.util.ResourceBundle.Control.*;

public class MyJVMTest_10131 {

    static String key = "`}Rbwbq\"j.";

    static Properties props = null;

    Object handleGetObject(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        return props.get(key);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10131().handleGetObject(key));
    }
}
