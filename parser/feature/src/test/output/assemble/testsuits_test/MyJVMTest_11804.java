public class MyJVMTest_11804 {

    void m() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11804().m();
    }
}
