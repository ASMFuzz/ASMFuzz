public class MyJVMTest_7803 {

    static String what = "GvLB?nva\"I";

    static double result = Double.MAX_VALUE;

    static double correctResult = Double.NaN;

    String go(String what, double result, double correctResult) {
        String v = what + ": got " + result + ", expected " + correctResult;
        if (!(Double.toString(result).equals(Double.toString(correctResult))))
            throw new RuntimeException(v);
        System.err.println(v);
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7803().go(what, result, correctResult);
    }
}
