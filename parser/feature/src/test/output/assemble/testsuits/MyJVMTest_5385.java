import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_5385 {

    static String value = "\"j &8tD5>p";

    static BasicAttributes attrs = null;

    String setGivenName(String value) {
        attrs.put(new BasicAttribute("givenName", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5385().setGivenName(value);
    }
}
