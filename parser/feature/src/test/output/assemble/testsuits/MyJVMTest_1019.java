import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_1019 {

    static String value = "_f)e-W9=)Y";

    static BasicAttributes attrs = null;

    String setDepartmentNumber(String value) {
        attrs.put(new BasicAttribute("departmentNumber", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1019().setDepartmentNumber(value);
    }
}
