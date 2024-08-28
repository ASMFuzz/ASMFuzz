public class MyJVMTest_9890 {

    static boolean cond = true;

    static String firstName = "l=}>$h,TvO";

    static String lastName = "'bi~uCzvmk";

    static int age = 0;

    boolean assertTrue(boolean cond) {
        if (!cond)
            throw new AssertionError();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9890().assertTrue(cond);
    }
}
