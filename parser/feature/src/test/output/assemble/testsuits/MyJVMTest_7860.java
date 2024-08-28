public class MyJVMTest_7860 {

    static float f = Float.POSITIVE_INFINITY;

    static int i = 0;

    static Float ib1 = 0f;

    float testp2(float f, int i, Float ib1) {
        Float ib2 = f + 1.f;
        if ((i & 1) == 0) {
            ib1 = new Float(f + 1.f);
            ib2 = (f + 2.f);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7860().testp2(f, i, ib1));
    }
}
