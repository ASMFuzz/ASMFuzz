import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_5636 {

    static String value = "E(\"VUkt|+V";

    static BasicAttributes attrs = null;

    String setTeletexTerminalID(String value) {
        attrs.put(new BasicAttribute("teletexTerminalIdentifier", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5636().setTeletexTerminalID(value);
    }
}
