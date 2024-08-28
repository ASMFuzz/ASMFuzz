public class MyJVMTest_640 {

    void doThrow() throws OnThrowException {
        System.out.println("target doing throw");
        throw new OnThrowException();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_640().doThrow();
    }
}
