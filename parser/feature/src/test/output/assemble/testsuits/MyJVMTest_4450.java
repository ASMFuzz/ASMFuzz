import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_4450 {

    static String value = "k4JK,|JOF ";

    static BasicAttributes attrs = null;

    String setRegisteredAddress(String value) {
        attrs.put(new BasicAttribute("registeredAddress", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4450().setRegisteredAddress(value);
    }
}
