import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_17281 {

    static String value = "!;[\\9]u@DQ";

    static BasicAttributes attrs = null;

    String setEmployeeType(String value) {
        attrs.put(new BasicAttribute("employeeType", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17281().setEmployeeType(value);
    }
}
