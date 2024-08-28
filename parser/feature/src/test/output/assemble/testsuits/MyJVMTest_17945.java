public class MyJVMTest_17945 {

    static boolean cond = false;

    static int assertionCount = 0;

    boolean assertTrue(boolean cond) {
        if (!cond) {
            throw new AssertionError();
        }
        assertionCount++;
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17945().assertTrue(cond);
    }
}
