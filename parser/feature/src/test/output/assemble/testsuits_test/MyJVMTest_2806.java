import java.math.*;
import static java.math.BigDecimal.*;

public class MyJVMTest_2806 {

    int powersOf2and5() {
        int failures = 0;
        for (int i = 0; i < 6; i++) {
            int powerOf2 = (int) StrictMath.pow(2.0, i);
            for (int j = 0; j < 6; j++) {
                int powerOf5 = (int) StrictMath.pow(5.0, j);
                int product;
                BigDecimal bd;
                try {
                    bd = BigDecimal.ONE.divide(new BigDecimal(product = powerOf2 * powerOf5));
                } catch (ArithmeticException e) {
                    failures++;
                    System.err.println((new BigDecimal(powerOf2)).toString() + " / " + (new BigDecimal(powerOf5)).toString() + " threw an exception.");
                    e.printStackTrace();
                }
                try {
                    bd = new BigDecimal(powerOf2).divide(new BigDecimal(powerOf5));
                } catch (ArithmeticException e) {
                    failures++;
                    System.err.println((new BigDecimal(powerOf2)).toString() + " / " + (new BigDecimal(powerOf5)).toString() + " threw an exception.");
                    e.printStackTrace();
                }
                try {
                    bd = new BigDecimal(powerOf5).divide(new BigDecimal(powerOf2));
                } catch (ArithmeticException e) {
                    failures++;
                    System.err.println((new BigDecimal(powerOf5)).toString() + " / " + (new BigDecimal(powerOf2)).toString() + " threw an exception.");
                    e.printStackTrace();
                }
            }
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2806().powersOf2and5());
    }
}
