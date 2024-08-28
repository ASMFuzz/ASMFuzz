import java.lang.management.*;
import javax.management.*;
import static java.lang.management.ManagementFactory.*;

public class MyJVMTest_5692 {

    static Object[] arr = { 0, 1, 7, -624416959, 3, 2, 21154074, 0, 6, 7 };

    static String message = "TyaYpA[t<8";

    String assertEmptyArray(Object[] arr, String message) throws Exception {
        if (arr.length > 0) {
            throw new RuntimeException("TEST FAILED: " + message);
        }
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5692().assertEmptyArray(arr, message);
    }
}
