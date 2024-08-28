public class MyJVMTest_13811 {

    static float f = Float.NEGATIVE_INFINITY;

    static int i = -676207295;

    static Float ibc = new Float(1.f);

    float testc(float f, int i) {
        Float ib = ibc;
        if ((i & 1) == 0)
            ib = new Float(f + 1.f);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13811().testc(f, i));
    }
}
