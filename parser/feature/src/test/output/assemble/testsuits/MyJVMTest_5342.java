import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_5342 {

    static String value = ">-[X*)|gZ3";

    static BasicAttributes attrs = null;

    String setSecretaryName(String value) {
        attrs.put(new BasicAttribute("secretary", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5342().setSecretaryName(value);
    }
}
