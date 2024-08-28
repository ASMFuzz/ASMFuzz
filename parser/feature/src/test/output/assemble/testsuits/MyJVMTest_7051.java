public class MyJVMTest_7051 {

    static float f = Float.POSITIVE_INFINITY;

    static int i = 8;

    float testb2(float f, int i) {
        Float ib1 = f;
        Float ib2 = f + 1.f;
        if ((i & 1) == 0) {
            ib1 = (f + 1.f);
            ib2 = (f + 2.f);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7051().testb2(f, i));
    }
}
