import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_16086 {

    static String value = "AyFv=^g5oR";

    static BasicAttributes attrs = null;

    String setStreetAddress(String value) {
        attrs.put(new BasicAttribute("street", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16086().setStreetAddress(value);
    }
}
