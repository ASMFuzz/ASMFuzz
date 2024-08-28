import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_4075 {

    static String value = "-jjL.06KHc";

    static BasicAttributes attrs = null;

    String setSeeAlso(String value) {
        attrs.put(new BasicAttribute("seeAlso", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4075().setSeeAlso(value);
    }
}
