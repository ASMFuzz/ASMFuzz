import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_10781 {

    static String value = "TE6<RNM}r ";

    static BasicAttributes attrs = null;

    String setHomePostalAddress(String value) {
        attrs.put(new BasicAttribute("homePostalAddress", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10781().setHomePostalAddress(value);
    }
}
