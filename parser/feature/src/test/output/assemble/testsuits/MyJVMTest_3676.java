import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_3676 {

    static String value = "WI_k!8rmK/";

    static BasicAttributes attrs = null;

    String setUserID(String value) {
        attrs.put(new BasicAttribute("uid", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3676().setUserID(value);
    }
}
