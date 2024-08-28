import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_13013 {

    static String value = "?P3js9@90\"";

    static BasicAttributes attrs = null;

    String setUserID(String value) {
        attrs.put(new BasicAttribute("uid", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13013().setUserID(value);
    }
}
