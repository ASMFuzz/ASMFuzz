public class MyJVMTest_10786 {

    static Object o = 0;

    void m1(Object o) {
    }

    Object m2(Object o) {
        m1(o);
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10786().m2(o);
    }
}
