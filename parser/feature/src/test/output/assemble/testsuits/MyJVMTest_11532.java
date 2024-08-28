import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_11532 {

    static String value = "sa$/,~7{?>";

    static BasicAttributes attrs = null;

    String setUserPKCS12(String value) {
        attrs.put(new BasicAttribute("userPKCS12", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11532().setUserPKCS12(value);
    }
}
