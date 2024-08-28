import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_4802 {

    static String value = "t;u+V(0\"7y";

    static BasicAttributes attrs = null;

    String setDisplayName(String value) {
        attrs.put(new BasicAttribute("displayName", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4802().setDisplayName(value);
    }
}
