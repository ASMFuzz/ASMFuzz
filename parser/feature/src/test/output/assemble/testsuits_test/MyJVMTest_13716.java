public class MyJVMTest_13716 {

    void m() {
        class Inner {

            Inner() {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13716().m();
    }
}
