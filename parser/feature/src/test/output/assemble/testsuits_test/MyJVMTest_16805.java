import java.math.*;
import static java.math.BigDecimal.*;

public class MyJVMTest_16805 {

    int simpleTests() {
        int failures = 0;
        BigDecimal[] bd1 = { new BigDecimal(new BigInteger("7812404666936930160"), 11), new BigDecimal(new BigInteger("7812404666936930160"), 12), new BigDecimal(new BigInteger("7812404666936930160"), 13) };
        BigDecimal bd2 = new BigDecimal(new BigInteger("2790000"), 1);
        BigDecimal[] expectedResult = { new BigDecimal("78403046.66936930160"), new BigDecimal("8091404.666936930160"), new BigDecimal("1060240.4666936930160") };
        for (int i = 0; i < bd1.length; i++) {
            if (!bd1[i].add(bd2).equals(expectedResult[i]))
                failures++;
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16805().simpleTests());
    }
}
