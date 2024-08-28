import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_17166 {

    static String value = "F:j}{M@Mf]";

    static BasicAttributes attrs = null;

    String setPreferredLanguage(String value) {
        attrs.put(new BasicAttribute("preferredLanguage", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17166().setPreferredLanguage(value);
    }
}
