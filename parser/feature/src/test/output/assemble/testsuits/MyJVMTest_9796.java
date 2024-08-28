import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_9796 {

    static byte[] value = { -78, 3, -109, -23, 73, -21, 104, 76, 6, 26 };

    static BasicAttributes attrs = null;

    byte[] setAudio(byte[] value) {
        attrs.put(new BasicAttribute("audio", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9796().setAudio(value);
    }
}
