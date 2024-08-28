public class MyJVMTest_13417 {

    static boolean cond = true;

    boolean assertTrue(boolean cond) {
        if (!cond)
            throw new AssertionError();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13417().assertTrue(cond);
    }
}
