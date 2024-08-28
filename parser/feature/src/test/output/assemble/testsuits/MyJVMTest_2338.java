public class MyJVMTest_2338 {

    static Object[] o = { 1, 6, 5, 7, 8, 0, 0, 3, 0, 0 };

    static B[] b = new B[10];

    Object[] m0(Object[] o) {
        if (o.getClass() == Object[].class) {
        }
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2338().m0(o);
    }
}
