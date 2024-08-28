public class MyJVMTest_8364 {

    static boolean cond = true;

    static int assertionCount = 0;

    boolean assertTrue(boolean cond) {
        if (!cond) {
            throw new AssertionError();
        }
        assertionCount++;
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8364().assertTrue(cond);
    }
}
