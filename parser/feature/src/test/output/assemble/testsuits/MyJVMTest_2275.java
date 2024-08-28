import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_2275 {

    static String value = "\"87BeiX@/k";

    static BasicAttributes attrs = null;

    String setUserPKCS12(String value) {
        attrs.put(new BasicAttribute("userPKCS12", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2275().setUserPKCS12(value);
    }
}
