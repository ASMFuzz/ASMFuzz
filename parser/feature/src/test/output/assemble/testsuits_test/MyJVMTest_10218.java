public class MyJVMTest_10218 {

    static float f = 0f;

    static int i = 0;

    float test(float f, int i) {
        Float ib = new Float(f);
        if ((i & 1) == 0)
            ib = f + 1.f;
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10218().test(f, i));
    }
}
