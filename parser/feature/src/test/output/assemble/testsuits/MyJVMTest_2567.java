import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_2567 {

    static String value = "laZz\\^qy2$";

    static BasicAttributes attrs = null;

    String setTelephoneNumber(String value) {
        attrs.put(new BasicAttribute("telephoneNumber", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2567().setTelephoneNumber(value);
    }
}
