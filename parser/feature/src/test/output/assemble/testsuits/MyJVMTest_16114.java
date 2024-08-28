public class MyJVMTest_16114 {

    static boolean cond = true;

    static T t = null;

    boolean assertTrue(boolean cond) {
        if (!cond)
            throw new AssertionError();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16114().assertTrue(cond);
    }
}
