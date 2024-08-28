public class MyJVMTest_9810 {

    void doThrow() throws OnThrowException {
        System.out.println("target doing throw");
        throw new OnThrowException();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9810().doThrow();
    }
}
