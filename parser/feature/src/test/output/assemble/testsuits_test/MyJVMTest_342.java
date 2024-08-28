import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_342 {

    static String value = "]e'PrAVI!)";

    static BasicAttributes attrs = null;

    String setMailAddress(String value) {
        attrs.put(new BasicAttribute("mail", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_342().setMailAddress(value);
    }
}
