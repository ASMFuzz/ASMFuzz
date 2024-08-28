import java.math.*;
import java.util.*;

public class MyJVMTest_17296 {

    static double bdParam1 = 0.6599111817282564;

    static BigDecimal bd = new BigDecimal(bdParam1);

    BigDecimal square(BigDecimal bd) {
        return bd.multiply(bd);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17296().square(bd));
    }
}
