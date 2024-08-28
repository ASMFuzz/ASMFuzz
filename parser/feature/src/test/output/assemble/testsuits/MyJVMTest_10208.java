import javax.naming.*;
import javax.naming.directory.*;

public class MyJVMTest_10208 {

    static String value = "DH!7 qvYH|";

    static BasicAttributes attrs = null;

    String setDepartmentNumber(String value) {
        attrs.put(new BasicAttribute("departmentNumber", value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10208().setDepartmentNumber(value);
    }
}
