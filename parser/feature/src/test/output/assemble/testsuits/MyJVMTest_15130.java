import java.lang.management.*;
import javax.management.*;
import static java.lang.management.ManagementFactory.*;

public class MyJVMTest_15130 {

    static Object[] arr = { 7, 662727854, 1908246515, 8, 0, 0, 8, 0, 3, 0 };

    static String message = "$GBP<e33rW";

    String assertEmptyArray(Object[] arr, String message) throws Exception {
        if (arr.length > 0) {
            throw new RuntimeException("TEST FAILED: " + message);
        }
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15130().assertEmptyArray(arr, message);
    }
}
