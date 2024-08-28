import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_13270 {

    static String value = "2f_;R~>%?3";

    static BasicAttributes attrs = null;

    String setLocalityName(String value) {
        attrs.put(new BasicAttribute("localityName", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13270().setLocalityName(value);
    }
}
