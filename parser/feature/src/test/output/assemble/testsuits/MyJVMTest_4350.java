import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_4350 {

    static String value = ",dUC'mCn]j";

    static BasicAttributes attrs = null;

    String setPostOfficeBox(String value) {
        attrs.put(new BasicAttribute("postOfficeBox", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4350().setPostOfficeBox(value);
    }
}
