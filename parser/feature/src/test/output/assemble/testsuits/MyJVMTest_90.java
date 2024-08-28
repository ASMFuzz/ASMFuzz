import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_90 {

    static String value = "u$Tp_rE%bc";

    static BasicAttributes attrs = null;

    String setFaxNumber(String value) {
        attrs.put(new BasicAttribute("facsimileTelephoneNumber", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_90().setFaxNumber(value);
    }
}
