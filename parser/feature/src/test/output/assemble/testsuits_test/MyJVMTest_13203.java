import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_13203 {

    static String value = "O,cbTP!l/)";

    static BasicAttributes attrs = null;

    String setStateOrProvinceName(String value) {
        attrs.put(new BasicAttribute("st", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13203().setStateOrProvinceName(value);
    }
}
