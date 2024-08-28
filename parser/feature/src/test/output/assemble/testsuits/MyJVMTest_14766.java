import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_14766 {

    static String value = "`fc}}8\"\\}l";

    static BasicAttributes attrs = null;

    String setSecretaryName(String value) {
        attrs.put(new BasicAttribute("secretary", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14766().setSecretaryName(value);
    }
}
