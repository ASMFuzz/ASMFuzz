public class MyJVMTest_6080 {

    static boolean do_throw = true;

    void not_inlined() throws MyException {
        if (do_throw) {
            throw new MyException();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6080().not_inlined();
    }
}
