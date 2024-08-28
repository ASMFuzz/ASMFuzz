import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_11126 {

    static String value = "FgT.$A\\$!e";

    static BasicAttributes attrs = null;

    String setInitials(String value) {
        attrs.put(new BasicAttribute("initials", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11126().setInitials(value);
    }
}
