public class MyJVMTest_1029 {

    static float f = Float.MAX_VALUE;

    static int i = -1663874763;

    float test(float f, int i) {
        Float ib = new Float(f);
        if ((i & 1) == 0)
            ib = f + 1.f;
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1029().test(f, i));
    }
}
