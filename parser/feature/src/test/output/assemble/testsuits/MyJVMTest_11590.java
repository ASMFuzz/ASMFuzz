import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_11590 {

    static String value = "TyxoPqPM\"Y";

    static BasicAttributes attrs = null;

    String setPreferredDeliveryMethod(String value) {
        attrs.put(new BasicAttribute("preferredDeliveryMethod", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11590().setPreferredDeliveryMethod(value);
    }
}
