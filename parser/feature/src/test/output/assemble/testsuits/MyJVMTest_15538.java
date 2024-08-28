public class MyJVMTest_15538 {

    static boolean do_throw = true;

    void not_inlined() throws MyException {
        if (do_throw) {
            throw new MyException();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15538().not_inlined();
    }
}
