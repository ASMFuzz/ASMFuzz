public class MyJVMTest_9488 {

    static boolean isAt = false;

    static char[] a = { Character.MAX_VALUE, 'm', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, 'k', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE };

    static int index = 4;

    static int limit = 932493026;

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
        new MyJVMTest_9488().callCodePoint(isAt, a, index, limit, expectedException);
    }
}
