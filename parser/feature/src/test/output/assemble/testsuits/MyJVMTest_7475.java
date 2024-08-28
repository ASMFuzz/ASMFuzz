public class MyJVMTest_7475 {

    static String what = "jR(01#mpHr";

    static float result = Float.POSITIVE_INFINITY;

    static float correctResult = 0f;

    String go(String what, float result, float correctResult) {
        String v = what + ": got " + result + ", expected " + correctResult;
        if (!(Float.toString(result).equals(Float.toString(correctResult))))
            throw new RuntimeException(v);
        System.err.println(v);
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7475().go(what, result, correctResult);
    }
}
