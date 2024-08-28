import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_4272 {

    static String value = "v=$4d5j:!B";

    static BasicAttributes attrs = null;

    String setHomePhoneNumber(String value) {
        attrs.put(new BasicAttribute("homePhone", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4272().setHomePhoneNumber(value);
    }
}
