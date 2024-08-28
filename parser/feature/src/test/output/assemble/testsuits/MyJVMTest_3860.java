import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_3860 {

    static String value = "15JS=K{zG7";

    static BasicAttributes attrs = null;

    String setStateOrProvinceName(String value) {
        attrs.put(new BasicAttribute("st", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3860().setStateOrProvinceName(value);
    }
}
