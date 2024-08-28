import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_9951 {

    static String value = "lT1I;rnK:1";

    static BasicAttributes attrs = null;

    String setPostalCode(String value) {
        attrs.put(new BasicAttribute("postalCode", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9951().setPostalCode(value);
    }
}
