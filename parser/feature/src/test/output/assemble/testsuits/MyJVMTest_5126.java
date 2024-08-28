public class MyJVMTest_5126 {

    static float f1 = 0f;

    static float f2 = Float.MIN_VALUE;

    boolean equalsFloat(float f1, float f2) {
        return (f1 - f2 < 0.0001) && (f2 - f1 < 0.0001);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5126().equalsFloat(f1, f2));
    }
}
