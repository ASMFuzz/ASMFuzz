public class MyJVMTest_299 {

    static float f = Float.NaN;

    void not_inlined() throws MyException {
        if (do_throw) {
            throw new MyException();
        }
    }

    static Object field = 4;

    static boolean do_throw = false;

    static boolean barrier = true;

    float test(float f) {
        Object v = null;
        try {
            not_inlined();
            v = field;
        } catch (MyException me) {
            v = field;
            barrier = true;
        }
        if (v == null) {
            return f * f;
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_299().test(f));
    }
}
