public class MyJVMTest_6194 {

    static boolean cond = true;

    static int assertionCount = 0;

    static Integer n = 5;

    boolean assertTrue(boolean cond) {
        assertionCount++;
        if (!cond)
            throw new AssertionError();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6194().assertTrue(cond);
    }
}
