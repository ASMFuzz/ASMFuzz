import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_4819 {

    static String value = ";8lu>KQUrD";

    static BasicAttributes attrs = null;

    String setTitle(String value) {
        attrs.put(new BasicAttribute("title", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4819().setTitle(value);
    }
}
