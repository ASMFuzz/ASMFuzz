import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_14634 {

    static String value = "]5d7LEX Q*";

    static BasicAttributes attrs = null;

    String setPhoto(String value) {
        attrs.put(new BasicAttribute("photo", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14634().setPhoto(value);
    }
}
