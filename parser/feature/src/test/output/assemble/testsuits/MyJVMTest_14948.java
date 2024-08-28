public class MyJVMTest_14948 {

    static float f1 = 0f;

    static float f2 = Float.NaN;

    boolean equals(float f1, float f2) {
        return Math.abs(f2 - f1) < 1.0E-9;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14948().equals(f1, f2));
    }
}
