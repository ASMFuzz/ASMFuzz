import java.math.BigDecimal;
import java.math.BigInteger;

public class MyJVMTest_1023 {

    static String val = "{SriHh8EYk";

    void fail(String val, float n) {
        throw new RuntimeException("Float.parseFloat failed. String:" + val + " Result:" + n);
    }

    static BigDecimal HALF = BigDecimal.valueOf(0.5);

    static String[] badStrings = { "", "+", "-", "+e", "-e", "+e170", "-e170", "1234   e10", "-1234   e10", "1\u0007e1", "1e\u00071", "NaNf", "NaNF", "NaNd", "NaND", "-NaNf", "-NaNF", "-NaNd", "-NaND", "+NaNf", "+NaNF", "+NaNd", "+NaND", "Infinityf", "InfinityF", "Infinityd", "InfinityD", "-Infinityf", "-InfinityF", "-Infinityd", "-InfinityD", "+Infinityf", "+InfinityF", "+Infinityd", "+InfinityD", "NaNe10", "-NaNe10", "+NaNe10", "Infinitye10", "-Infinitye10", "+Infinitye10", "\u0661e\u0661", "\u06F1e\u06F1", "\u0967e\u0967" };

    static String[] goodStrings = { "NaN", "+NaN", "-NaN", "Infinity", "+Infinity", "-Infinity", "1.1e-23f", ".1e-23f", "1e-23", "1f", "1", "2", "1234", "-1234", "+1234", "2147483647", "2147483648", "-2147483648", "-2147483649", "16777215", "16777216", "16777217", "-16777215", "-16777216", "-16777217", "9007199254740991", "9007199254740992", "9007199254740993", "-9007199254740991", "-9007199254740992", "-9007199254740993", "9223372036854775807", "9223372036854775808", "9223372036854775809", "-9223372036854775808", "-9223372036854775809", "-9223372036854775810" };

    static String[] paddedBadStrings = {"{yr'/&4p*6","i9Ek?Ycn=W","iNHG,/inLx",":IM24)d.ql","@)22%/r;Vx","19^!&GNi9,","C>1/a ccs ","b|L`XLrgDu","R2+mPQIctV","k[LLiiq('$"};

    static String[] paddedGoodStrings = {" WG1V[<\"L9","3{-'\"EldF]","f17J*aU2)C","VrYRzo'i0U","Y:~!ObYh=n","VUMY$%eEwK","enrqjLs.Z0","@CQ.tlL~5o","/;vh,i72X'","eI2I\\Ivv-U"};

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
        new MyJVMTest_1023().check(val);
    }
}
