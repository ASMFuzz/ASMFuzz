public class MyJVMTest_17420 {

    static float f = Float.MAX_VALUE;

    static int i = 8;

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
        System.out.println(new MyJVMTest_17420().testp2(f, i, ib1));
    }
}
