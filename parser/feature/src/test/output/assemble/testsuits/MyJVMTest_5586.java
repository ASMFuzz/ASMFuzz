import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_5586 {

    static String value = "U^D'9)[UA!";

    static BasicAttributes attrs = null;

    String setPostalAddress(String value) {
        attrs.put(new BasicAttribute("postalAddress", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5586().setPostalAddress(value);
    }
}
