public class MyJVMTest_11381 {

    static Object[] o = { 9, 1, 0, 1, 7, 0, 1, 1264528785, 0, 3 };

    static boolean cond = true;

    void m0(Object[] o) {
        if (o.getClass() == Object[].class) {
        }
    }

    static B[] b = new B[10];

    Object[] m1(Object[] o, boolean cond) {
        if (cond) {
            o = b;
        }
        m0(o);
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11381().m1(o, cond);
    }
}
