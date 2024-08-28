import java.math.*;
import java.util.*;

public class MyJVMTest_7742 {

    static long bdParam1 = -1432351082593679714L;

    static String bdParam2Param1 = "L`Cmr%XO\\$";

    static MathContext bdParam2 = new MathContext(bdParam2Param1);

    static BigDecimal bd = new BigDecimal(bdParam1, bdParam2);

    BigDecimal square(BigDecimal bd) {
        return bd.multiply(bd);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7742().square(bd));
    }
}
