import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_11544 {

    static String value = "m8O@ >\\2Pt";

    static BasicAttributes attrs = null;

    String setDestinationIndicator(String value) {
        attrs.put(new BasicAttribute("destinationIndicator", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11544().setDestinationIndicator(value);
    }
}
