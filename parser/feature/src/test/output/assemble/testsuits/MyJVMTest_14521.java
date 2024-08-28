public class MyJVMTest_14521 {

    void m() {
        Object o = 42;
        int i = (int) o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14521().m();
    }
}
