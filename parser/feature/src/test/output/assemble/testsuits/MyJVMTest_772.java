import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_772 {

    static String value = "1)KxeX:[C ";

    static BasicAttributes attrs = null;

    String setPostalCode(String value) {
        attrs.put(new BasicAttribute("postalCode", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_772().setPostalCode(value);
    }
}
