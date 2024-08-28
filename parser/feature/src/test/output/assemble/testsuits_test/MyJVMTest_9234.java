import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_9234 {

    static String value = "X$dfp#Y``j";

    static BasicAttributes attrs = null;

    String setFaxNumber(String value) {
        attrs.put(new BasicAttribute("facsimileTelephoneNumber", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9234().setFaxNumber(value);
    }
}
