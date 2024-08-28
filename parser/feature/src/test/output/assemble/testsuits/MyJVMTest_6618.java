public class MyJVMTest_6618 {

    static boolean cond = false;

    static T t = null;

    boolean assertTrue(boolean cond) {
        if (!cond)
            throw new AssertionError();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6618().assertTrue(cond);
    }
}
