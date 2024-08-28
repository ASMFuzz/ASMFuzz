public class MyJVMTest_860 {

    void foo() throws Exception {
        AnonInnerExceptionAux x = new AnonInnerExceptionAux() {
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_860().foo();
    }
}
