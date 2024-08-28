import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_13835 {

    static String value = "*E,HGhmGkL";

    static BasicAttributes attrs = null;

    String setRegisteredAddress(String value) {
        attrs.put(new BasicAttribute("registeredAddress", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13835().setRegisteredAddress(value);
    }
}
