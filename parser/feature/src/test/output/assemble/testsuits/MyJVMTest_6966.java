public class MyJVMTest_6966 {

    static float f = Float.NaN;

    static int i = 9;

    float testb(float f, int i) {
        Float ib = f;
        if ((i & 1) == 0)
            ib = (f + 1.f);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6966().testb(f, i));
    }
}
