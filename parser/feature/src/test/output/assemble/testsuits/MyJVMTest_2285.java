import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_2285 {

    static String value = "Sx;}yv%o2n";

    static BasicAttributes attrs = null;

    String setDestinationIndicator(String value) {
        attrs.put(new BasicAttribute("destinationIndicator", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2285().setDestinationIndicator(value);
    }
}
