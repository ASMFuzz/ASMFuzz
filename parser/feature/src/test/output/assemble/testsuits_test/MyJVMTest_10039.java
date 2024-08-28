public class MyJVMTest_10039 {

    void foo() throws Exception {
        AnonInnerExceptionAux x = new AnonInnerExceptionAux() {
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10039().foo();
    }
}
