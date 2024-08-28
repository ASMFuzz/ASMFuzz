import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_11977 {

    static String value = "e%e~Ow WNB";

    static BasicAttributes attrs = null;

    String setCarLicense(String value) {
        attrs.put(new BasicAttribute("carLicense", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11977().setCarLicense(value);
    }
}
