public class MyJVMTest_7149 {

    static float f = 0.38719136f;

    static int i = 1;

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
        System.out.println(new MyJVMTest_7149().testb_deop(f, i));
    }
}
