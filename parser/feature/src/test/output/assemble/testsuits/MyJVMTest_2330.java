import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_2330 {

    static String value = "8sF0 [2>3+";

    static BasicAttributes attrs = null;

    String setPreferredDeliveryMethod(String value) {
        attrs.put(new BasicAttribute("preferredDeliveryMethod", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2330().setPreferredDeliveryMethod(value);
    }
}
