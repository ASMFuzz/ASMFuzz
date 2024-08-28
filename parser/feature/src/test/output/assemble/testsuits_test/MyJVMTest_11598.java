public class MyJVMTest_11598 {

    static Object[] o = { 0, 1477768753, 1711946394, -1140116725, 2, 8, 0, 0, 2, 0 };

    static B[] b = new B[10];

    Object[] m0(Object[] o) {
        if (o.getClass() == Object[].class) {
        }
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11598().m0(o);
    }
}
