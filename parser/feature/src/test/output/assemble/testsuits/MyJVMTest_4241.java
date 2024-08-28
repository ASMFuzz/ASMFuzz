import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_4241 {

    static String value = "5az8Yc9]~4";

    static BasicAttributes attrs = null;

    String setPagerNumber(String value) {
        attrs.put(new BasicAttribute("pager", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4241().setPagerNumber(value);
    }
}
