import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_8295 {

    static String value = "ih\\=*z\"(GZ";

    static BasicAttributes attrs = null;

    String setMobileNumber(String value) {
        attrs.put(new BasicAttribute("mobile", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8295().setMobileNumber(value);
    }
}
