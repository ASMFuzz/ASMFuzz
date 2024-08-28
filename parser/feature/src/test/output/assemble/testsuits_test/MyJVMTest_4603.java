public class MyJVMTest_4603 {

    static float f = Float.MIN_VALUE;

    static int i = 261800016;

    static Float ibc = new Float(1.f);

    float testc2(float f, int i) {
        Float ib1 = ibc;
        Float ib2 = f + 1.f;
        if ((i & 1) == 0) {
            ib1 = (ibc + 1.f);
            ib2 = (f + 2.f);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4603().testc2(f, i));
    }
}
