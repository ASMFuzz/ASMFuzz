public class MyJVMTest_851 {

    static boolean cond = false;

    static int assertionCount = 0;

    boolean assertTrue(boolean cond) {
        assertionCount++;
        if (!cond) {
            throw new AssertionError();
        }
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_851().assertTrue(cond);
    }
}
