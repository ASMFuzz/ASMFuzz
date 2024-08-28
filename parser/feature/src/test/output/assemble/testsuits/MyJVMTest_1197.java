import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_1197 {

    static String value = "5vx*Md;J8>";

    static BasicAttributes attrs = null;

    String setX500UniqueID(String value) {
        attrs.put(new BasicAttribute("x500UniqueIdentifier", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1197().setX500UniqueID(value);
    }
}
