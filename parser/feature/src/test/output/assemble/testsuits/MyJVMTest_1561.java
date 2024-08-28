import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_1561 {

    static String value = "/so7\"!/*vW";

    static BasicAttributes attrs = null;

    String setHomePostalAddress(String value) {
        attrs.put(new BasicAttribute("homePostalAddress", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1561().setHomePostalAddress(value);
    }
}
