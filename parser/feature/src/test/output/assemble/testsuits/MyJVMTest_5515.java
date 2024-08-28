public class MyJVMTest_5515 {

    static float f1 = 0f;

    static float f2 = Float.MIN_VALUE;

    boolean equals(float f1, float f2) {
        return Math.abs(f2 - f1) < 1.0E-9;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5515().equals(f1, f2));
    }
}
