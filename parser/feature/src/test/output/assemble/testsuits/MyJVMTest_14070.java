import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_14070 {

    static String value = "\\k):?_>x4f";

    static BasicAttributes attrs = null;

    String setUserPassword(String value) {
        attrs.put(new BasicAttribute("userPassword", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14070().setUserPassword(value);
    }
}
