import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_14718 {

    static String value = "LW(Wu-E(7z";

    static BasicAttributes attrs = null;

    String setManagerName(String value) {
        attrs.put(new BasicAttribute("manager", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14718().setManagerName(value);
    }
}
