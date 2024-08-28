import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_6589 {

    static String value = "T(^?R;?XL!";

    static BasicAttributes attrs = null;

    String setUserCertificate(String value) {
        attrs.put(new BasicAttribute("userCertificate", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6589().setUserCertificate(value);
    }
}
