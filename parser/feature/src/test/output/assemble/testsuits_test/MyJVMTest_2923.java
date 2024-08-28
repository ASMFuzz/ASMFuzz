public class MyJVMTest_2923 {

    static float f = Float.NaN;

    static int i = 0;

    static Float ib = Float.MIN_VALUE;

    float testp(float f, int i, Float ib) {
        if ((i & 1) == 0)
            ib = new Float(f + 1.f);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2923().testp(f, i, ib));
    }
}
