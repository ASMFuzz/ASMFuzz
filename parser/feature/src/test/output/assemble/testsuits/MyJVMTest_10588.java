import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MyJVMTest_10588 {

    static String[] value = new String[75];

    static String[][] results = new String[75][75];

    int mcDivideTests() {
        int failures = 0;
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                BigDecimal v1 = new BigDecimal(value[i]);
                BigDecimal v2 = new BigDecimal(value[j]);
                BigDecimal res1 = v1.divide(v2, MathContext.DECIMAL64);
                if (!res1.toString().equals(results[i][j])) {
                    failures++;
                    System.err.println("Unexpected result from " + v1 + " / " + v2 + "; expected " + results[i][j] + " got " + res1);
                }
            }
        }
        for (int mpc = 1; mpc < 23; mpc++) {
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    BigDecimal v1 = new BigDecimal(value[i]);
                    BigDecimal v2 = new BigDecimal(value[j]);
                    BigDecimal res1 = v1.divide(v2, new MathContext(mpc, RoundingMode.HALF_EVEN));
                    BigDecimal res2 = v1.divide(v2, new MathContext(128, RoundingMode.HALF_EVEN)).round(new MathContext(mpc, RoundingMode.HALF_EVEN));
                    if (!res1.equals(res2)) {
                        failures++;
                        System.err.println("Unexpected result from " + v1 + " / " + v2 + "; expected " + res2 + " got " + res1);
                    }
                }
            }
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10588().mcDivideTests());
    }
}
