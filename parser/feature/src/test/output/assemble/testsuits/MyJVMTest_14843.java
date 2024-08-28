import java.math.*;
import java.util.*;

public class MyJVMTest_14843 {

    static BigDecimal[] zeros = new BigDecimal[23];

    int toEngineeringStringTests() {
        int failures = 0;
        String[][] testCases = { { "0E+10", "0.00E+12" }, { "0E+9", "0E+9" }, { "0E+8", "0.0E+9" }, { "0E+7", "0.00E+9" }, { "0E-10", "0.0E-9" }, { "0E-9", "0E-9" }, { "0E-8", "0.00E-6" }, { "0E-7", "0.0E-6" } };
        for (String[] testCase : testCases) {
            BigDecimal bd = new BigDecimal(testCase[0]);
            String result = bd.toEngineeringString();
            if (!result.equals(testCase[1]) || !bd.equals(new BigDecimal(result))) {
                failures++;
                System.err.println("From input ``" + testCase[0] + ",'' " + " bad engineering string output ``" + result + "''; expected ``" + testCase[1] + ".''");
            }
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14843().toEngineeringStringTests());
    }
}
