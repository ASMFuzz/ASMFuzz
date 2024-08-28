public class MyJVMTest_13810 {

    static boolean isAt = true;

    static CharSequence cs = null;

    static int index = 0;

    static Class expectedException = null;

    static boolean At = true, Before = false;

    Class callCodePoint(boolean isAt, CharSequence cs, int index, Class expectedException) {
        try {
            int c = isAt ? Character.codePointAt(cs, index) : Character.codePointBefore(cs, index);
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
        new MyJVMTest_13810().callCodePoint(isAt, cs, index, expectedException);
    }
}
