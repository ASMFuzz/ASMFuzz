import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_11845 {

    static String value = "7.WctJ,C>H";

    static BasicAttributes attrs = null;

    String setTelephoneNumber(String value) {
        attrs.put(new BasicAttribute("telephoneNumber", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11845().setTelephoneNumber(value);
    }
}
