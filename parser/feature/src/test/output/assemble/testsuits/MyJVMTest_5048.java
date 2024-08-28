import java.util.regex.*;
import java.math.BigDecimal;
import java.math.BigInteger;

public class MyJVMTest_5048 {

    static String val = "#F^5[&GTm ";

    void fail(String val, double n) {
        throw new RuntimeException("Double.parseDouble failed. String:" + val + " Result:" + n);
    }

    static BigDecimal HALF = BigDecimal.valueOf(0.5);

    static String[] badStrings = { "", "+", "-", "+e", "-e", "+e170", "-e170", "1234   e10", "-1234   e10", "1\u0007e1", "1e\u00071", "NaNf", "NaNF", "NaNd", "NaND", "-NaNf", "-NaNF", "-NaNd", "-NaND", "+NaNf", "+NaNF", "+NaNd", "+NaND", "Infinityf", "InfinityF", "Infinityd", "InfinityD", "-Infinityf", "-InfinityF", "-Infinityd", "-InfinityD", "+Infinityf", "+InfinityF", "+Infinityd", "+InfinityD", "NaNe10", "-NaNe10", "+NaNe10", "Infinitye10", "-Infinitye10", "+Infinitye10", "\u0661e\u0661", "\u06F1e\u06F1", "\u0967e\u0967", ".", "e42", ".e42", "d", ".d", "e42d", ".e42d", "1A01.01125e-10d", "2;3.01125e-10d", "1_34.01125e-10d", "202..01125e-10d", "202,01125e-10d", "202.03b4e-10d", "202.06_3e-10d", "202.01125e-f0d", "202.01125e_3d", "202.01125e -5d", "202.01125e-10r", "202.01125e-10ff", "1234L.01", "12ee-2", "12e-2.2.2", "12.01e+", "12.01E", "00x1.0p1", "1.0p1", "00010p1", "deadbeefp1", "0x1.0p", "0x1.0", "0x1.0pa", "0x1.0pf", "0x1.0e22", "0x1.0e22", "0xp22" };

    static String[] goodStrings = { "NaN", "+NaN", "-NaN", "Infinity", "+Infinity", "-Infinity", "1.1e-23f", ".1e-23f", "1e-23", "1f", "0", "-0", "+0", "00", "00", "-00", "+00", "0000000000", "-0000000000", "+0000000000", "1", "2", "1234", "-1234", "+1234", "2147483647", "2147483648", "-2147483648", "-2147483649", "16777215", "16777216", "16777217", "-16777215", "-16777216", "-16777217", "9007199254740991", "9007199254740992", "9007199254740993", "-9007199254740991", "-9007199254740992", "-9007199254740993", "9223372036854775807", "9223372036854775808", "9223372036854775809", "-9223372036854775808", "-9223372036854775809", "-9223372036854775810", "54.07140d", "7.01e-324d", "2147483647.01d", "1.2147483647f", "000000000000000000000000001.F", "1.00000000000000000000000000e-2F", "2.", ".0909", "122112217090.0", "7090e-5", "2.E-20", ".0909e42", "122112217090.0E+100", "7090f", "2.F", ".0909d", "122112217090.0D", "7090e-5f", "2.E-20F", ".0909e42d", "122112217090.0E+100D", "\u0035\u0031\u0034\u0039\u0032\u0033\u0036\u0037\u0038\u0030.1102E-209D", "1290873\u002E12301e100", "1.1E-10\u0066", "0.0E-10", "1E10", "0.f", "1f", "0.F", "1F", "0.12d", "1e-0d", "12.e+1D", "0e-0D", "12.e+01", "1e-01", "0x1p1", "0X1p1", "0x1P1", "0X1P1", "0x1p1f", "0X1p1f", "0x1P1f", "0X1P1f", "0x1p1F", "0X1p1F", "0x1P1F", "0X1P1F", "0x1p1d", "0X1p1d", "0x1P1d", "0X1P1d", "0x1p1D", "0X1p1D", "0x1P1D", "0X1P1D", "-0x1p1", "-0X1p1", "-0x1P1", "-0X1P1", "-0x1p1f", "-0X1p1f", "-0x1P1f", "-0X1P1f", "-0x1p1F", "-0X1p1F", "-0x1P1F", "-0X1P1F", "-0x1p1d", "-0X1p1d", "-0x1P1d", "-0X1P1d", "-0x1p1D", "-0X1p1D", "-0x1P1D", "-0X1P1D", "0x1p-1", "0X1p-1", "0x1P-1", "0X1P-1", "0x1p-1f", "0X1p-1f", "0x1P-1f", "0X1P-1f", "0x1p-1F", "0X1p-1F", "0x1P-1F", "0X1P-1F", "0x1p-1d", "0X1p-1d", "0x1P-1d", "0X1P-1d", "0x1p-1D", "0X1p-1D", "0x1P-1D", "0X1P-1D", "-0x1p-1", "-0X1p-1", "-0x1P-1", "-0X1P-1", "-0x1p-1f", "-0X1p-1f", "-0x1P-1f", "-0X1P-1f", "-0x1p-1F", "-0X1p-1F", "-0x1P-1F", "-0X1P-1F", "-0x1p-1d", "-0X1p-1d", "-0x1P-1d", "-0X1P-1d", "-0x1p-1D", "-0X1p-1D", "-0x1P-1D", "-0X1P-1D", "0xap1", "0xbp1", "0xcp1", "0xdp1", "0xep1", "0xfp1", "0x1p1", "0x.1p1", "0x1.1p1", "0x001p23", "0x00.1p1", "0x001.1p1", "0x100p1", "0x.100p1", "0x1.100p1", "0x00100p1", "0x00.100p1", "0x001.100p1", "1.7976931348623157E308", "4.9e-324", "2.2250738585072014e-308", "2.2250738585072012e-308", "1.7976931348623158e+308", "1.7976931348623159e+308", "2.4703282292062329e-324", "2.4703282292062327e-324", "2.4703282292062325e-324", "0.0000000000001e321", "00.000000000000000001e326", "00000.000000000000000001e326", "000.0000000000000000001e327", "0.00000000000000000001e328" };

    static String[] paddedBadStrings = {"\\!&)\\?_#wH","9`)U;TMXp!","k\" ^*k'R)/","l_Oym\",#bc","RkB'qX<~T8","l3x6JB4X?>","*lD`+VxR7D","lKkrFkkIRK","{\\h|F{OHL<","v5DURA+Z*\""};

    static String[] paddedGoodStrings = {"\" !4=khNfb","'ORTdV@ODa","6<ZUj JgBY","!dz1|H\\at-","}27NFX MH}","'>V%N-w| 0","HE!.(sazp/","+`WliU`)Tb","%s?*5V?QS>","'=n6LLFA(X"};

    String check(String val) {
        double n = Double.parseDouble(val);
        boolean isNegativeN = n < 0 || n == 0 && 1 / n < 0;
        double na = Math.abs(n);
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
            if (!Double.isNaN(n)) {
                fail(val, n);
            }
            return;
        }
        if (Double.isNaN(n)) {
            fail(val, n);
        }
        if (isNegativeN != isNegative)
            fail(val, n);
        if (s.equals("infinity")) {
            if (na != Double.POSITIVE_INFINITY) {
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
        if (Double.isInfinite(na)) {
            l = new BigDecimal(Double.MAX_VALUE).add(new BigDecimal(Math.ulp(Double.MAX_VALUE)).multiply(HALF));
            u = null;
        } else {
            l = new BigDecimal(na).subtract(new BigDecimal(Math.ulp(Math.nextUp(-na))).multiply(HALF));
            u = new BigDecimal(na).add(new BigDecimal(Math.ulp(n)).multiply(HALF));
        }
        int cmpL = bd.compareTo(l);
        int cmpU = u != null ? bd.compareTo(u) : -1;
        if ((Double.doubleToLongBits(n) & 1) != 0) {
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
        new MyJVMTest_5048().check(val);
    }
}
