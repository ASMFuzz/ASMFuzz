import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_17496 {

    static String value = ">%tB}>=kKe";

    static BasicAttributes attrs = null;

    String setOrganizationName(String value) {
        attrs.put(new BasicAttribute("o", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17496().setOrganizationName(value);
    }
}
