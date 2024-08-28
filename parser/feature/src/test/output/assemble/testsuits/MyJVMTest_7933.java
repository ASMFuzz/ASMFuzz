import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_7933 {

    static String value = "+OszsIe.$g";

    static BasicAttributes attrs = null;

    String setOrganizationName(String value) {
        attrs.put(new BasicAttribute("o", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7933().setOrganizationName(value);
    }
}
