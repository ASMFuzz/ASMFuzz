public class MyJVMTest_14754 {

    static boolean done = true;

    void foo() throws Exception {
        AnonInnerExceptionAux y = new AnonInnerExceptionAux() {

            {
                if (done)
                    throw new java.io.IOException();
            }
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14754().foo();
    }
}
