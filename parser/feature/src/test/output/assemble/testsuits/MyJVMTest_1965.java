import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_1965 {

    static String value = "`$KZ*rkKKB";

    static BasicAttributes attrs = null;

    String setOrganizationalUnitName(String value) {
        attrs.put(new BasicAttribute("ou", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1965().setOrganizationalUnitName(value);
    }
}
