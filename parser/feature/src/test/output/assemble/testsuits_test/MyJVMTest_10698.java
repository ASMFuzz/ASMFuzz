public class MyJVMTest_10698 {

    static boolean cond = true;

    static int assertionCount = 0;

    boolean assertTrue(boolean cond) {
        assertionCount++;
        if (!cond)
            throw new AssertionError();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10698().assertTrue(cond);
    }
}
