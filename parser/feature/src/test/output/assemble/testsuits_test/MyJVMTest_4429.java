public class MyJVMTest_4429 {

    static float f = 0f;

    static int i = 1;

    static Float ibc = new Float(1.f);

    float testc(float f, int i) {
        Float ib = ibc;
        if ((i & 1) == 0)
            ib = new Float(f + 1.f);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4429().testc(f, i));
    }
}
