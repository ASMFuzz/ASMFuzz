import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_2852 {

    static String value = "acOE<k<~X}";

    static BasicAttributes attrs = null;

    String setJPEGPhoto(String value) {
        attrs.put(new BasicAttribute("jpegPhoto", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2852().setJPEGPhoto(value);
    }
}
