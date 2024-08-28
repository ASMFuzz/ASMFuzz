public class MyJVMTest_5007 {

    static Object v = new Object();

    static Object v2 = 4;

    void m2() {
        v2 = v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5007().m2();
    }
}
