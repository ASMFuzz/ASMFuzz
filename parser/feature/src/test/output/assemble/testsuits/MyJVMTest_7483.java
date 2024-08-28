public class MyJVMTest_7483 {

    static float a = Float.MAX_VALUE;

    static float b = Float.NaN;

    float check(float a, float b) {
        if (a != b)
            throw new Error(a + " != " + b);
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7483().check(a, b);
    }
}
