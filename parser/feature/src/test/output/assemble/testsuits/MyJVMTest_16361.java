import java.lang.reflect.*;
import java.util.*;

public class MyJVMTest_16361 {

    static String key = "bu/!.O0*'h";

    static ResourceBundle bundle = null;

    static Method m = null;

    Object handleGetObject(String key) {
        try {
            return m.invoke(bundle, key);
        } catch (Exception e) {
            throw new RuntimeException("handleGetObject error", e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16361().handleGetObject(key));
    }
}
