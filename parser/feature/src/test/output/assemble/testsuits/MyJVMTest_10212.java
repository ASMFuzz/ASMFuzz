import java.math.BigDecimal;
import java.math.BigInteger;

public class MyJVMTest_10212 {

    static String val = "P\\\\ (ty*M^";

    void fail(String val, float n) {
        throw new RuntimeException("Float.parseFloat failed. String:" + val + " Result:" + n);
    }

    static BigDecimal HALF = BigDecimal.valueOf(0.5);

    static String[] badStrings = { "", "+", "-", "+e", "-e", "+e170", "-e170", "1234   e10", "-1234   e10", "1\u0007e1", "1e\u00071", "NaNf", "NaNF", "NaNd", "NaND", "-NaNf", "-NaNF", "-NaNd", "-NaND", "+NaNf", "+NaNF", "+NaNd", "+NaND", "Infinityf", "InfinityF", "Infinityd", "InfinityD", "-Infinityf", "-InfinityF", "-Infinityd", "-InfinityD", "+Infinityf", "+InfinityF", "+Infinityd", "+InfinityD", "NaNe10", "-NaNe10", "+NaNe10", "Infinitye10", "-Infinitye10", "+Infinitye10", "\u0661e\u0661", "\u06F1e\u06F1", "\u0967e\u0967" };

    static String[] goodStrings = { "NaN", "+NaN", "-NaN", "Infinity", "+Infinity", "-Infinity", "1.1e-23f", ".1e-23f", "1e-23", "1f", "1", "2", "1234", "-1234", "+1234", "2147483647", "2147483648", "-2147483648", "-2147483649", "16777215", "16777216", "16777217", "-16777215", "-16777216", "-16777217", "9007199254740991", "9007199254740992", "9007199254740993", "-9007199254740991", "-9007199254740992", "-9007199254740993", "9223372036854775807", "9223372036854775808", "9223372036854775809", "-9223372036854775808", "-9223372036854775809", "-9223372036854775810" };

    static String[] paddedBadStrings = {"9`LMcvIeHu","V0[0p[IncG","0MumbHr=Vr","^xgsTLWLAl","N`R8;bI}lW","QBS+ZAz7mj","'CV[bW)T~d","_ugCsDi[\"I","4g7?a8{c\"Q","a,fUm4n3>\""};

    static String[] paddedGoodStrings = {":K[s72rg@ "," GK=s*3A5l","hrPwPWO/3.","\\<G_B]K74`","FFz{[7D,_&","MMzN$/v gu","Sz<U<C7O;<","&MMzmCN3Wi","_1?FvLA2%M","4DLdnp(V f"};

    String check(String val) {
        float n = Float.parseFloat(val);
        boolean isNegativeN = n < 0 || n == 0 && 1 / n < 0;
        float na = Math.abs(n);
        String s = val.trim().toLowerCase();
        switch(s.charAt(s.length() - 1)) {
            case 'd':
            case 'f':
                s = s.substring(0, s.length() - 1);
                break;
        }
        boolean isNegative = false;
        if (s.charAt(0) == '+') {
            s = s.substring(1);
        } else if (s.charAt(0) == '-') {
            s = s.substring(1);
            isNegative = true;
        }
        if (s.equals("nan")) {
            if (!Float.isNaN(n)) {
                fail(val, n);
            }
            return;
        }
        if (Float.isNaN(n)) {
            fail(val, n);
        }
        if (isNegativeN != isNegative)
            fail(val, n);
        if (s.equals("infinity")) {
            if (na != Float.POSITIVE_INFINITY) {
                fail(val, n);
            }
            return;
        }
        BigDecimal bd;
        if (s.startsWith("0x")) {
            s = s.substring(2);
            int indP = s.indexOf('p');
            long exp = Long.parseLong(s.substring(indP + 1));
            int indD = s.indexOf('.');
            String significand;
            if (indD >= 0) {
                significand = s.substring(0, indD) + s.substring(indD + 1, indP);
                exp -= 4 * (indP - indD - 1);
            } else {
                significand = s.substring(0, indP);
            }
            bd = new BigDecimal(new BigInteger(significand, 16));
            if (exp >= 0) {
                bd = bd.multiply(BigDecimal.valueOf(2).pow((int) exp));
            } else {
                bd = bd.divide(BigDecimal.valueOf(2).pow((int) -exp));
            }
        } else {
            bd = new BigDecimal(s);
        }
        BigDecimal l, u;
        if (Float.isInfinite(na)) {
            l = new BigDecimal(Float.MAX_VALUE).add(new BigDecimal(Math.ulp(Float.MAX_VALUE)).multiply(HALF));
            u = null;
        } else {
            l = new BigDecimal(na).subtract(new BigDecimal(Math.ulp(-Math.nextUp(-na))).multiply(HALF));
            u = new BigDecimal(na).add(new BigDecimal(Math.ulp(n)).multiply(HALF));
        }
        int cmpL = bd.compareTo(l);
        int cmpU = u != null ? bd.compareTo(u) : -1;
        if ((Float.floatToIntBits(n) & 1) != 0) {
            if (cmpL <= 0 || cmpU >= 0) {
                fail(val, n);
            }
        } else {
            if (cmpL < 0 || cmpU > 0) {
                fail(val, n);
            }
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10212().check(val);
    }
}
