public class MyJVMTest_769 {

    static boolean cond = false;

    static int assertionCount = 0;

    static int n = 5;

    boolean assertTrue(boolean cond) {
        assertionCount++;
        if (!cond)
            throw new AssertionError();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_769().assertTrue(cond);
    }
}
