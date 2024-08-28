import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_5217 {

    static String value = "hrIO\\a3>%3";

    static BasicAttributes attrs = null;

    String setPhoto(String value) {
        attrs.put(new BasicAttribute("photo", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5217().setPhoto(value);
    }
}
