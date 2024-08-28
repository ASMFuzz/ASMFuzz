import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_13890 {

    static String value = "'~+=T1TB`%";

    static BasicAttributes attrs = null;

    String setX121Address(String value) {
        attrs.put(new BasicAttribute("x121Address", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13890().setX121Address(value);
    }
}
