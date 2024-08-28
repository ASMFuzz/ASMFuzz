public class MyJVMTest_4059 {

    static boolean cond = true;

    boolean assertTrue(boolean cond) {
        if (!cond)
            throw new AssertionError();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4059().assertTrue(cond);
    }
}
