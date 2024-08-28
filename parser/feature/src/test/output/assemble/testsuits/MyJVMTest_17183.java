import java.math.*;
import static java.math.BigDecimal.*;

public class MyJVMTest_17183 {

    int arithmeticExceptionTest() {
        int failures = 0;
        BigDecimal x;
        try {
            x = new BigDecimal("1e2147483647").add(new BigDecimal(1));
            failures++;
        } catch (ArithmeticException ae) {
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17183().arithmeticExceptionTest());
    }
}
