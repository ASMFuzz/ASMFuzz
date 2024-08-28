import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_11954 {

    static String value = "D|oW'jDV|Q";

    static BasicAttributes attrs = null;

    String setPhysicalDeliveryOfficeName(String value) {
        attrs.put(new BasicAttribute("physicalDeliveryOfficeName", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11954().setPhysicalDeliveryOfficeName(value);
    }
}
