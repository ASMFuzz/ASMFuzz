import java.util.regex.*;

public class MyJVMTest_2754 {

    static String[] input = { "\"R:f9\\sy~z", "*j.u,2(:~/", "(ALCZ?@BQh", "F9To#Iu+s?", "j0Rm^;JTI1", "z>&=x`'>pO", "Lj\\~P5-LvH", "Hx+5H8g2W9", "n76sR(cMYg", "Jc:Tb~8Zri" };

    static boolean exceptionalInput = true;

    static String[] badStrings = { "", "+", "-", "+e", "-e", "+e170", "-e170", "1234   e10", "-1234   e10", "1\u0007e1", "1e\u00071", "NaNf", "NaNF", "NaNd", "NaND", "-NaNf", "-NaNF", "-NaNd", "-NaND", "+NaNf", "+NaNF", "+NaNd", "+NaND", "Infinityf", "InfinityF", "Infinityd", "InfinityD", "-Infinityf", "-InfinityF", "-Infinityd", "-InfinityD", "+Infinityf", "+InfinityF", "+Infinityd", "+InfinityD", "NaNe10", "-NaNe10", "+NaNe10", "Infinitye10", "-Infinitye10", "+Infinitye10", "\u0661e\u0661", "\u06F1e\u06F1", "\u0967e\u0967", ".", "e42", ".e42", "d", ".d", "e42d", ".e42d", "1A01.01125e-10d", "2;3.01125e-10d", "1_34.01125e-10d", "202..01125e-10d", "202,01125e-10d", "202.03b4e-10d", "202.06_3e-10d", "202.01125e-f0d", "202.01125e_3d", "202.01125e -5d", "202.01125e-10r", "202.01125e-10ff", "1234L.01", "12ee-2", "12e-2.2.2", "12.01e+", "12.01E", "00x1.0p1", "1.0p1", "00010p1", "deadbeefp1", "0x1.0p", "0x1.0", "0x1.0pa", "0x1.0pf", "0x1.0e22", "0x1.0e22", "0xp22" };

    static String[] goodStrings = { "NaN", "+NaN", "-NaN", "Infinity", "+Infinity", "-Infinity", "1.1e-23f", ".1e-23f", "1e-23", "1f", "0", "-0", "+0", "00", "00", "-00", "+00", "0000000000", "-0000000000", "+0000000000", "1", "2", "1234", "-1234", "+1234", "2147483647", "2147483648", "-2147483648", "-2147483649", "16777215", "16777216", "16777217", "-16777215", "-16777216", "-16777217", "9007199254740991", "9007199254740992", "9007199254740993", "-9007199254740991", "-9007199254740992", "-9007199254740993", "9223372036854775807", "9223372036854775808", "9223372036854775809", "-9223372036854775808", "-9223372036854775809", "-9223372036854775810", "54.07140d", "7.01e-324d", "2147483647.01d", "1.2147483647f", "000000000000000000000000001.F", "1.00000000000000000000000000e-2F", "2.", ".0909", "122112217090.0", "7090e-5", "2.E-20", ".0909e42", "122112217090.0E+100", "7090f", "2.F", ".0909d", "122112217090.0D", "7090e-5f", "2.E-20F", ".0909e42d", "122112217090.0E+100D", "\u0035\u0031\u0034\u0039\u0032\u0033\u0036\u0037\u0038\u0030.1102E-209D", "1290873\u002E12301e100", "1.1E-10\u0066", "0.0E-10", "1E10", "0.f", "1f", "0.F", "1F", "0.12d", "1e-0d", "12.e+1D", "0e-0D", "12.e+01", "1e-01", "0x1p1", "0X1p1", "0x1P1", "0X1P1", "0x1p1f", "0X1p1f", "0x1P1f", "0X1P1f", "0x1p1F", "0X1p1F", "0x1P1F", "0X1P1F", "0x1p1d", "0X1p1d", "0x1P1d", "0X1P1d", "0x1p1D", "0X1p1D", "0x1P1D", "0X1P1D", "-0x1p1", "-0X1p1", "-0x1P1", "-0X1P1", "-0x1p1f", "-0X1p1f", "-0x1P1f", "-0X1P1f", "-0x1p1F", "-0X1p1F", "-0x1P1F", "-0X1P1F", "-0x1p1d", "-0X1p1d", "-0x1P1d", "-0X1P1d", "-0x1p1D", "-0X1p1D", "-0x1P1D", "-0X1P1D", "0x1p-1", "0X1p-1", "0x1P-1", "0X1P-1", "0x1p-1f", "0X1p-1f", "0x1P-1f", "0X1P-1f", "0x1p-1F", "0X1p-1F", "0x1P-1F", "0X1P-1F", "0x1p-1d", "0X1p-1d", "0x1P-1d", "0X1P-1d", "0x1p-1D", "0X1p-1D", "0x1P-1D", "0X1P-1D", "-0x1p-1", "-0X1p-1", "-0x1P-1", "-0X1P-1", "-0x1p-1f", "-0X1p-1f", "-0x1P-1f", "-0X1P-1f", "-0x1p-1F", "-0X1p-1F", "-0x1P-1F", "-0X1P-1F", "-0x1p-1d", "-0X1p-1d", "-0x1P-1d", "-0X1P-1d", "-0x1p-1D", "-0X1p-1D", "-0x1P-1D", "-0X1P-1D", "0xap1", "0xbp1", "0xcp1", "0xdp1", "0xep1", "0xfp1", "0x1p1", "0x.1p1", "0x1.1p1", "0x001p23", "0x00.1p1", "0x001.1p1", "0x100p1", "0x.100p1", "0x1.100p1", "0x00100p1", "0x00.100p1", "0x001.100p1", "1.7976931348623157E308", "4.9e-324", "2.2250738585072014e-308", "2.2250738585072012e-308", "1.7976931348623158e+308", "1.7976931348623159e+308", "2.4703282292062329e-324", "2.4703282292062327e-324", "2.4703282292062325e-324", "0.0000000000001e321", "00.000000000000000001e326", "00000.000000000000000001e326", "000.0000000000000000001e327", "0.00000000000000000001e328" };

    static String[] paddedBadStrings = {"Is8S7E1g\\e","3->t@e2Nwl","_-;;f_5K/M","*AE{z`zrM ","45kaM,4(S7","P+{;(|/#,D","BCw%]F?Jkd",",;r:P#sl+7","]h0f|3\"{`#","/XCss;fHVk"};

    static String[] paddedGoodStrings = {"2o%\"mkj!!n",",DmYV(e$=%","\"@j5F48zyX","VQfW=-K[w]","^\"x(s^PdV0","ztw%rwVzv'","}nw1g5MLLx","@2wnDP;jkm","K#5J1Yb>lG","fg.r/4!3og"};

    String testRegex(String[] input, boolean exceptionalInput) {
        final String Digits = "(\\p{Digit}+)";
        final String HexDigits = "(\\p{XDigit}+)";
        final String Exp = "[eE][+-]?" + Digits;
        final String fpRegex = ("[\\x00-\\x20]*" + "[+-]?(" + "NaN|" + "Infinity|" + "((((" + Digits + "(\\.)?(" + Digits + "?)(" + Exp + ")?)|" + "(\\.(" + Digits + ")(" + Exp + ")?))|" + "((" + "(0[xX]" + HexDigits + "(\\.)?)|" + "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" + ")[pP][+-]?" + Digits + "))" + "[fFdD]?))" + "[\\x00-\\x20]*");
        Pattern fpPattern = Pattern.compile(fpRegex);
        for (int i = 0; i < input.length; i++) {
            Matcher m = fpPattern.matcher(input[i]);
            if (m.matches() != !exceptionalInput) {
                throw new RuntimeException("Regular expression " + (exceptionalInput ? "accepted bad" : "rejected good") + " string `" + input[i] + "'.");
            }
        }
        return Digits;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2754().testRegex(input, exceptionalInput);
    }
}
