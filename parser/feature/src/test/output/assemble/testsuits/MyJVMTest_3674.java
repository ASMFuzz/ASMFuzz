import java.math.*;
import java.util.*;

public class MyJVMTest_3674 {

    static BigDecimal[] zeros = new BigDecimal[23];

    int setScaleTests() {
        int failures = 0;
        int[] scales = { Integer.MIN_VALUE, Integer.MIN_VALUE + 1, -10000000, -3, -2, -1, 0, 1, 2, 3, 10, 10000000, Integer.MAX_VALUE - 1, Integer.MAX_VALUE };
        for (BigDecimal zero : zeros) {
            for (int scale : scales) {
                try {
                    BigDecimal bd = zero.setScale(scale);
                } catch (ArithmeticException e) {
                    failures++;
                    System.err.println("Exception when trying to set a scale of " + scale + " on " + zero);
                }
            }
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3674().setScaleTests());
    }
}
