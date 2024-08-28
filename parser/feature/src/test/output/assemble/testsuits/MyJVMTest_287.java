import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_287 {

    static String value = "^8mzLbF[I{";

    static BasicAttributes attrs = null;

    String setDescription(String value) {
        attrs.put(new BasicAttribute("description", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_287().setDescription(value);
    }
}
