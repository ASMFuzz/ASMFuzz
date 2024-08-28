import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_7620 {

    static String value = "5FBpE+meUJ";

    static BasicAttributes attrs = null;

    String setPreferredLanguage(String value) {
        attrs.put(new BasicAttribute("preferredLanguage", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7620().setPreferredLanguage(value);
    }
}
