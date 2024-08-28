import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_5070 {

    static String value = "3(ANZ(^m_.";

    static BasicAttributes attrs = null;

    String setTelexNumber(String value) {
        attrs.put(new BasicAttribute("telexNumber", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5070().setTelexNumber(value);
    }
}
