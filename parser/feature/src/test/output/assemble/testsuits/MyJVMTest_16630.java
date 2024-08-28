public class MyJVMTest_16630 {

    static float f = 0.9891656f;

    static int i = 4;

    float foo(float i) {
        return i;
    }

    void dummy() {
    }

    float test_deop(float f, int i) {
        Float ib = new Float(foo(f));
        if ((i & 1) == 0)
            ib = foo(f + 1.f);
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16630().test_deop(f, i));
    }
}
