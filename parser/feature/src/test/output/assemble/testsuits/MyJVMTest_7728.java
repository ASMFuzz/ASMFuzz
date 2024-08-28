import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_7728 {

    static String value = "W~K2w(jd0y";

    static BasicAttributes attrs = null;

    String setEmployeeType(String value) {
        attrs.put(new BasicAttribute("employeeType", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7728().setEmployeeType(value);
    }
}
