public class MyJVMTest_6022 {

    static float f = Float.MIN_VALUE;

    static int i = 1405582913;

    float testm2(float f, int i) {
        Float ib1 = new Float(f);
        Float ib2 = f + 1.f;
        if ((i & 1) == 0) {
            ib1 = new Float(f + 1.f);
            ib2 = (f + 2.f);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6022().testm2(f, i));
    }
}
