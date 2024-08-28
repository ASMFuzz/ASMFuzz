public class MyJVMTest_14415 {

    static Object v = new Object();

    static Object v2 = 7;

    void m2() {
        v2 = v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14415().m2();
    }
}
