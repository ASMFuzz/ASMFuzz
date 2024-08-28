public class MyJVMTest_10500 {

    static boolean cond = true;

    static int assertionCount = 0;

    static int i = 40;

    boolean assertTrue(boolean cond) {
        assertionCount++;
        if (!cond)
            throw new AssertionError();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10500().assertTrue(cond);
    }
}
