public class MyJVMTest_13520 {

    void m() {
        java.util.Collections.max(null);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13520().m();
    }
}
