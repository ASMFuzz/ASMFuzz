import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_13433 {

    static String value = "'P~0+VQ}>7";

    static BasicAttributes attrs = null;

    String setSeeAlso(String value) {
        attrs.put(new BasicAttribute("seeAlso", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13433().setSeeAlso(value);
    }
}
