import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_629 {

    static byte[] value = { -23, -126, -88, -69, -2, -93, 68, 49, -79, 99 };

    static BasicAttributes attrs = null;

    byte[] setAudio(byte[] value) {
        attrs.put(new BasicAttribute("audio", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_629().setAudio(value);
    }
}
