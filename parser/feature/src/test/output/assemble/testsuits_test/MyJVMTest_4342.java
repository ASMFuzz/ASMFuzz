public class MyJVMTest_4342 {

    void m() {
        class Inner {

            Inner() {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4342().m();
    }
}
