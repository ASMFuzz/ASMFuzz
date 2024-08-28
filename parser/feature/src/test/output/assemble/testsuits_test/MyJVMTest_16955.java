public class MyJVMTest_16955 {

    static float f = Float.NaN;

    static int i = 0;

    float testm(float f, int i) {
        Float ib = f;
        if ((i & 1) == 0)
            ib = new Float(f + 1.f);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16955().testm(f, i));
    }
}
