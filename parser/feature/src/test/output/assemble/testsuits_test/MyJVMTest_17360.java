public class MyJVMTest_17360 {

    static String what = "wB8KlmZWi/";

    static double result = 0d;

    static double correctResult = 0.9070591434388641;

    String go(String what, double result, double correctResult) {
        String v = what + ": got " + result + ", expected " + correctResult;
        if (!(Double.toString(result).equals(Double.toString(correctResult))))
            throw new RuntimeException(v);
        System.err.println(v);
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17360().go(what, result, correctResult);
    }
}
