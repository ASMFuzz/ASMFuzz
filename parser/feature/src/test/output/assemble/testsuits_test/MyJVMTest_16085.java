import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_16085 {

    static String value = "}(BB{Af&-`";

    static BasicAttributes attrs = null;

    String setUserCertificate(String value) {
        attrs.put(new BasicAttribute("userCertificate", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16085().setUserCertificate(value);
    }
}
