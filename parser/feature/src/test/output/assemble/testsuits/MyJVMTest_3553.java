public class MyJVMTest_3553 {

    static boolean isAt = true;

    static char[] a = { '0', Character.MAX_VALUE, '/', Character.MIN_VALUE, Character.MIN_VALUE, 'C', 'F', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static int index = 278312079;

    static Class expectedException = null;

    static boolean At = true, Before = false;

    Class callCodePoint(boolean isAt, char[] a, int index, Class expectedException) {
        try {
            int c = isAt ? Character.codePointAt(a, index) : Character.codePointBefore(a, index);
        } catch (Exception e) {
            if (expectedException.isInstance(e)) {
                return;
            }
            throw new RuntimeException("Unspecified exception", e);
        }
        throw new RuntimeException("codePoint" + (isAt ? "At" : "Before") + " didn't throw " + expectedException.getName());
        return expectedException;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3553().callCodePoint(isAt, a, index, expectedException);
    }
}
