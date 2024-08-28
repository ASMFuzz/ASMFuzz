public class MyJVMTest_17020 {

    static float a = Float.MAX_VALUE;

    static float b = 0f;

    float check(float a, float b) {
        if (a != b)
            throw new Error(a + " != " + b);
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17020().check(a, b);
    }
}
