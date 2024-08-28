import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_13724 {

    static String value = ">5'<(u1=!)";

    static BasicAttributes attrs = null;

    String setPostOfficeBox(String value) {
        attrs.put(new BasicAttribute("postOfficeBox", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13724().setPostOfficeBox(value);
    }
}
