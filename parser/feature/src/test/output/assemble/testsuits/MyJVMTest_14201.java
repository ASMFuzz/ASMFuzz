import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_14201 {

    static String value = " %=&zueBm:";

    static BasicAttributes attrs = null;

    String setDisplayName(String value) {
        attrs.put(new BasicAttribute("displayName", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14201().setDisplayName(value);
    }
}
