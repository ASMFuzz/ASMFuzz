public class MyJVMTest_9080 {

    void m() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9080().m();
    }
}
