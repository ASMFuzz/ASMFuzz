import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_2692 {

    static String value = "/Ry#c|c}gJ";

    static BasicAttributes attrs = null;

    String setCarLicense(String value) {
        attrs.put(new BasicAttribute("carLicense", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2692().setCarLicense(value);
    }
}
