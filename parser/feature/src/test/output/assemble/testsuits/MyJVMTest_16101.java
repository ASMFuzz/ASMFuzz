import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_16101 {

    static String value = "i(nXx%Toa7";

    static BasicAttributes attrs = null;

    String setBusinessCategory(String value) {
        attrs.put(new BasicAttribute("businessCategory", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16101().setBusinessCategory(value);
    }
}
