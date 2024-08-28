import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_6605 {

    static String value = "wv?t=W4Rh*";

    static BasicAttributes attrs = null;

    String setBusinessCategory(String value) {
        attrs.put(new BasicAttribute("businessCategory", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6605().setBusinessCategory(value);
    }
}
