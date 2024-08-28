import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_4677 {

    static String value = "6`3=OiOYww";

    static BasicAttributes attrs = null;

    String setUserPassword(String value) {
        attrs.put(new BasicAttribute("userPassword", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4677().setUserPassword(value);
    }
}
