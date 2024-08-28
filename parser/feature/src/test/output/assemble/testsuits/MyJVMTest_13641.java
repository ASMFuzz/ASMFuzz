import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_13641 {

    static String value = "1TNK?iw={x";

    static BasicAttributes attrs = null;

    String setHomePhoneNumber(String value) {
        attrs.put(new BasicAttribute("homePhone", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13641().setHomePhoneNumber(value);
    }
}
