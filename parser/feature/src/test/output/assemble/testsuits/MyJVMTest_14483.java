import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_14483 {

    static String value = "jvj'@EBuzR";

    static BasicAttributes attrs = null;

    String setTelexNumber(String value) {
        attrs.put(new BasicAttribute("telexNumber", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14483().setTelexNumber(value);
    }
}
