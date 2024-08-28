import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_14810 {

    static String value = "B+\"Tsn?Nm\\";

    static BasicAttributes attrs = null;

    String setGivenName(String value) {
        attrs.put(new BasicAttribute("givenName", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14810().setGivenName(value);
    }
}
