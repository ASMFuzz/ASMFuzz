public class MyJVMTest_331 {

    static boolean isAt = true;

    static char[] a = { 'e', Character.MIN_VALUE, '.', Character.MIN_VALUE, '0', '0', Character.MAX_VALUE, 'P', '0', '0' };

    static int index = 4;

    static int limit = 6;

    static Class expectedException = null;

    static boolean At = true, Before = false;

    Class callCodePoint(boolean isAt, char[] a, int index, int limit, Class expectedException) {
        try {
            int c = isAt ? Character.codePointAt(a, index, limit) : Character.codePointBefore(a, index, limit);
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
        new MyJVMTest_331().callCodePoint(isAt, a, index, limit, expectedException);
    }
}
