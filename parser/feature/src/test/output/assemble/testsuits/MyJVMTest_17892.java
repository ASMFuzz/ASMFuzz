import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_17892 {

    static String value = "'b{1!z$Bf|";

    static BasicAttributes attrs = null;

    String setRoomNumber(String value) {
        attrs.put(new BasicAttribute("roomNumber", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17892().setRoomNumber(value);
    }
}
