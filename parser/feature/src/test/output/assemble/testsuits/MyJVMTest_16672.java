public class MyJVMTest_16672 {

    static float f = Float.POSITIVE_INFINITY;

    static int i = 0;

    float foo(float i) {
        return i;
    }

    void dummy() {
    }

    float testb_deop(float f, int i) {
        Float ib = foo(f);
        if ((i & 1) == 0)
            ib = foo(f + 1.f);
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16672().testb_deop(f, i));
    }
}
