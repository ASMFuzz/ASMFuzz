public class MyJVMTest_878 {

    static boolean assertion = true;

    boolean assertThat(boolean assertion) {
        if (!assertion) {
            throw new AssertionError();
        }
        return assertion;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_878().assertThat(assertion);
    }
}
