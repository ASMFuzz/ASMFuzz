public class MyJVMTest_14541 {

    static float f1 = Float.MAX_VALUE;

    static float f2 = 0.97365296f;

    boolean equalsFloat(float f1, float f2) {
        return (f1 - f2 < 0.0001) && (f2 - f1 < 0.0001);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14541().equalsFloat(f1, f2));
    }
}
