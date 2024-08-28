import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_17871 {

    static String value = "@'1WiUSMY*";

    static BasicAttributes attrs = null;

    String setMobileNumber(String value) {
        attrs.put(new BasicAttribute("mobile", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17871().setMobileNumber(value);
    }
}
