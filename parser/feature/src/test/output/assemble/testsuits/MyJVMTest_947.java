import java.io.*;
import java.net.*;
import java.util.*;
import static java.util.ResourceBundle.Control.*;

public class MyJVMTest_947 {

    static String key = "(PSLx[Q\\OS";

    static Properties props = null;

    Object handleGetObject(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        return props.get(key);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_947().handleGetObject(key));
    }
}
