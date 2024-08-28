public class MyJVMTest_14026 {

    static int codePoint = 952733194;

    static Class expectedException = null;

    Class callToChars1(int codePoint, Class expectedException) {
        try {
            char[] a = Character.toChars(codePoint);
        } catch (Exception e) {
            if (expectedException.isInstance(e)) {
                return;
            }
            throw new RuntimeException("Unspecified exception", e);
        }
        throw new RuntimeException("toChars(int) didn't throw " + expectedException.getName());
        return expectedException;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14026().callToChars1(codePoint, expectedException);
    }
}
