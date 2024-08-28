import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_10396 {

    static String value = "7&AATzDC;7";

    static BasicAttributes attrs = null;

    String setX500UniqueID(String value) {
        attrs.put(new BasicAttribute("x500UniqueIdentifier", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10396().setX500UniqueID(value);
    }
}
