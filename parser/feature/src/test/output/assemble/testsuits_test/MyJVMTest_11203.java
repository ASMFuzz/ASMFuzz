import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_11203 {

    static String value = "ix#kiA?``L";

    static BasicAttributes attrs = null;

    String setOrganizationalUnitName(String value) {
        attrs.put(new BasicAttribute("ou", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11203().setOrganizationalUnitName(value);
    }
}
