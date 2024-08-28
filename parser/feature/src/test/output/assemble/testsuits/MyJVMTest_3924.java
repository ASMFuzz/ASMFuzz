import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_3924 {

    static String value = "Yiw7J;7pN5";

    static BasicAttributes attrs = null;

    String setLocalityName(String value) {
        attrs.put(new BasicAttribute("localityName", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3924().setLocalityName(value);
    }
}
