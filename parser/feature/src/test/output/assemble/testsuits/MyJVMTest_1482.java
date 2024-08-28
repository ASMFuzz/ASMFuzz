public class MyJVMTest_1482 {

    static boolean cond = false;

    static int assertionCount = 0;

    boolean assertTrue(boolean cond) {
        assertionCount++;
        if (!cond)
            throw new AssertionError();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1482().assertTrue(cond);
    }
}
