import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_8315 {

    static String value = "O\"~lYUYLyl";

    static BasicAttributes attrs = null;

    String setRoomNumber(String value) {
        attrs.put(new BasicAttribute("roomNumber", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8315().setRoomNumber(value);
    }
}
