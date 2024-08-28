public class MyJVMTest_5105 {

    void m() {
        try {
        } catch (Exception e) {
        }
        try {
        } catch (Exception e) {
        } finally {
        }
        try {
        } finally {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5105().m();
    }
}
