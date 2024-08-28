public class MyJVMTest_2530 {

    void m() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2530().m();
    }
}
