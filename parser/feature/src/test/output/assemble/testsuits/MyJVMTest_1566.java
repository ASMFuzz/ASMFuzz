public class MyJVMTest_1566 {

    static Object o = 8;

    void m1(Object o) {
    }

    Object m2(Object o) {
        m1(o);
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1566().m2(o);
    }
}
