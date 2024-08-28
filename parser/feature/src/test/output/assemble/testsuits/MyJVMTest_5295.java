import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_5295 {

    static String value = "_}%JpV/o $";

    static BasicAttributes attrs = null;

    String setManagerName(String value) {
        attrs.put(new BasicAttribute("manager", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5295().setManagerName(value);
    }
}
