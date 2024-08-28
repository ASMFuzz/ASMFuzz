public class MyJVMTest_17011 {

    static String what = "N6Y>RV)jkK";

    static float result = Float.NEGATIVE_INFINITY;

    static float correctResult = Float.NaN;

    String go(String what, float result, float correctResult) {
        String v = what + ": got " + result + ", expected " + correctResult;
        if (!(Float.toString(result).equals(Float.toString(correctResult))))
            throw new RuntimeException(v);
        System.err.println(v);
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17011().go(what, result, correctResult);
    }
}
