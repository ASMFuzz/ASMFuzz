public class MyJVMTest_16477 {

    static float f = Float.NEGATIVE_INFINITY;

    static int i = 1560139295;

    float testb(float f, int i) {
        Float ib = f;
        if ((i & 1) == 0)
            ib = (f + 1.f);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16477().testb(f, i));
    }
}
