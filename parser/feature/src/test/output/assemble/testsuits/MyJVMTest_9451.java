public class MyJVMTest_9451 {

    static float f = Float.POSITIVE_INFINITY;

    void not_inlined() throws MyException {
        if (do_throw) {
            throw new MyException();
        }
    }

    static Object field = 822678415;

    static boolean do_throw = true;

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
        System.out.println(new MyJVMTest_9451().test(f));
    }
}
