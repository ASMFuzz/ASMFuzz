import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_1895 {

    static String value = "2DPUg)r'5-";

    static BasicAttributes attrs = null;

    String setInitials(String value) {
        attrs.put(new BasicAttribute("initials", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1895().setInitials(value);
    }
}
