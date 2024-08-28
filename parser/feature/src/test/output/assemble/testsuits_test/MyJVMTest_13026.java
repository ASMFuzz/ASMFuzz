public class MyJVMTest_13026 {

    static float f = Float.NaN;

    static int i = 436656927;

    float test2(float f, int i) {
        Float ib1 = new Float(f);
        Float ib2 = new Float(f + 1.f);
        if ((i & 1) == 0) {
            ib1 = new Float(f + 1.f);
            ib2 = new Float(f + 2.f);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13026().test2(f, i));
    }
}
