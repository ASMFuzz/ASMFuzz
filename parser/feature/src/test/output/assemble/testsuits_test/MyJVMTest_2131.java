public class MyJVMTest_2131 {

    static Object[] o = { 1, 2000888515, -1122917658, 0, 7, -18197086, 687531982, 416039088, 0, 0 };

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
        new MyJVMTest_2131().m1(o, cond);
    }
}
