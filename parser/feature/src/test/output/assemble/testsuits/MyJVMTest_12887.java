public class MyJVMTest_12887 {

    static boolean isAt = false;

    static char[] a = { '0', '&', '0', '0', Character.MAX_VALUE, 'S', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE };

    static int index = 2;

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
        new MyJVMTest_12887().callCodePoint(isAt, a, index, expectedException);
    }
}
