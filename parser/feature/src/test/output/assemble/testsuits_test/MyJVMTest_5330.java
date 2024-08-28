public class MyJVMTest_5330 {

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
        new MyJVMTest_5330().foo();
    }
}
