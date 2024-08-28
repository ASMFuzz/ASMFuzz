import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_15022 {

    static String value = "o7VkK'MHua";

    static BasicAttributes attrs = null;

    String setPostalAddress(String value) {
        attrs.put(new BasicAttribute("postalAddress", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15022().setPostalAddress(value);
    }
}
