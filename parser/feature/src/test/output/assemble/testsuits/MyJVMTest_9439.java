import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_9439 {

    static String value = "Jaq/`a#ab\"";

    static BasicAttributes attrs = null;

    String setDescription(String value) {
        attrs.put(new BasicAttribute("description", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9439().setDescription(value);
    }
}
