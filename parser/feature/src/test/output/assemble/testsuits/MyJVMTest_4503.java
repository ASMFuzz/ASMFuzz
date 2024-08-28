import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_4503 {

    static String value = "wAXABVLMhs";

    static BasicAttributes attrs = null;

    String setX121Address(String value) {
        attrs.put(new BasicAttribute("x121Address", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4503().setX121Address(value);
    }
}
