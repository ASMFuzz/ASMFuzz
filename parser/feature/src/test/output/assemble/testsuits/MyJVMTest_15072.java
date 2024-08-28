import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_15072 {

    static String value = "lHL;,:=Cin";

    static BasicAttributes attrs = null;

    String setTeletexTerminalID(String value) {
        attrs.put(new BasicAttribute("teletexTerminalIdentifier", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15072().setTeletexTerminalID(value);
    }
}
