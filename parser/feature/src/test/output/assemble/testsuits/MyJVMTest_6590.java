import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_6590 {

    static String value = "2CsV-<#![{";

    static BasicAttributes attrs = null;

    String setStreetAddress(String value) {
        attrs.put(new BasicAttribute("street", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6590().setStreetAddress(value);
    }
}
