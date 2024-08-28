import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_14218 {

    static String value = "VGRz^*X!8a";

    static BasicAttributes attrs = null;

    String setTitle(String value) {
        attrs.put(new BasicAttribute("title", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14218().setTitle(value);
    }
}
