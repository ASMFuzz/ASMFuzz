import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_1873 {

    static String value = "ub(3Nm5NC0";

    static BasicAttributes attrs = null;

    String setEmployeeNumber(String value) {
        attrs.put(new BasicAttribute("employeeNumber", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1873().setEmployeeNumber(value);
    }
}
