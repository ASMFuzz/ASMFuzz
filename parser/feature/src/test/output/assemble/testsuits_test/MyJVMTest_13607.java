import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_13607 {

    static String value = "ua\\%XKSlC/";

    static BasicAttributes attrs = null;

    String setPagerNumber(String value) {
        attrs.put(new BasicAttribute("pager", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13607().setPagerNumber(value);
    }
}
