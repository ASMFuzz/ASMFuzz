public class MyJVMTest_7111 {

    static float f = 0f;

    static int i = -1069064824;

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
        System.out.println(new MyJVMTest_7111().test_deop(f, i));
    }
}
