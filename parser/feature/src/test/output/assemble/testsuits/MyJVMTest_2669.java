import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_2669 {

    static String value = "[-mbGC:ZD[";

    static BasicAttributes attrs = null;

    String setPhysicalDeliveryOfficeName(String value) {
        attrs.put(new BasicAttribute("physicalDeliveryOfficeName", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2669().setPhysicalDeliveryOfficeName(value);
    }
}
