public class MyJVMTest_5108 {

    void m() {
        Object o = 42;
        int i = (int) o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5108().m();
    }
}
