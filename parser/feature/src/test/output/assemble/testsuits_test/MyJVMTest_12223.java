public class MyJVMTest_12223 {

    static float f = 0f;

    static int i = 5;

    static Float ib = Float.NaN;

    float testp(float f, int i, Float ib) {
        if ((i & 1) == 0)
            ib = new Float(f + 1.f);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12223().testp(f, i, ib));
    }
}
