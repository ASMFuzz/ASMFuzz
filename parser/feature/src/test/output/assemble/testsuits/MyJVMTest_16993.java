import java.text.*;
import java.util.*;

public class MyJVMTest_16993 {

    static double[] f1Param1 = { 0d, Double.POSITIVE_INFINITY, 0d, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0.3476217454653834, Double.POSITIVE_INFINITY, 0d, 0.8875648312551505, 0.41600611812248733 };

    static String[] f1Param2 = { "M<'b%292un", "Pc)0oZuZIs", "OC@wA> Dtm", "t^EWS)#1+M", "nHDrFi\"CUX", "6ECgrQHGq_", "n)`;qyWFnb", "xIp;PtU-ly", "DRvt6,mGc>", "U6|xa)Em#+" };

    static ChoiceFormat f1 = new ChoiceFormat(f1Param1, f1Param2);

    static double[] f2Param1 = { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.NaN, 0d, Double.POSITIVE_INFINITY, Double.NaN };

    static String[] f2Param2 = { "c^d;uL`/o(", "a7!+s{{1TQ", "{S;`,JpD(C", "_KBSEA rF|", "o+jHj6dCS6", "W54z,N$:*l", "%IW|Nbip%)", "8P &\\}h5`\\", "s\\gTT}Ajq6", "]cPN-q~n?)" };

    static ChoiceFormat f2 = new ChoiceFormat(f2Param1, f2Param2);

    static boolean expected = false;

    boolean check(ChoiceFormat f1, ChoiceFormat f2, boolean expected) {
        boolean got = f1.equals(f2);
        if (got != expected) {
            throw new RuntimeException("Test failed for ChoiceFormat.equals(). Got: " + got + ", Expected: " + expected);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16993().check(f1, f2, expected);
    }
}
