import java.math.*;
import java.util.*;

public class MyJVMTest_15643 {

    static BigDecimal[] zeros = new BigDecimal[23];

    int ulpTests() {
        int failures = 0;
        for (BigDecimal zero : zeros) {
            BigDecimal result;
            BigDecimal expected = BigDecimal.valueOf(1, zero.scale());
            if (!(result = zero.ulp()).equals(expected)) {
                failures++;
                System.err.println("Unexpected ulp value for zero value " + zero + "; expected " + expected + ", got " + result);
            }
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15643().ulpTests());
    }
}
