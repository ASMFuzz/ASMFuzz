import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_11102 {

    static String value = "O]p5Xau:}0";

    static BasicAttributes attrs = null;

    String setEmployeeNumber(String value) {
        attrs.put(new BasicAttribute("employeeNumber", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11102().setEmployeeNumber(value);
    }
}
