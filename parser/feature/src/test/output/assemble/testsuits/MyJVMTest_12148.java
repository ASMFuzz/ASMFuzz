import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_12148 {

    static String value = "Kp9674Q6Px";

    static BasicAttributes attrs = null;

    String setJPEGPhoto(String value) {
        attrs.put(new BasicAttribute("jpegPhoto", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12148().setJPEGPhoto(value);
    }
}
