import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_9499 {

    static String value = "3<U].\"K\\If";

    static BasicAttributes attrs = null;

    String setMailAddress(String value) {
        attrs.put(new BasicAttribute("mail", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9499().setMailAddress(value);
    }
}
