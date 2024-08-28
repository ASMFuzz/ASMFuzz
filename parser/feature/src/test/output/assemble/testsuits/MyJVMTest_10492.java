public class MyJVMTest_10492 {

    static char[] a = { '[', 'O', Character.MAX_VALUE, 'V', Character.MIN_VALUE, Character.MIN_VALUE, ';', '0', Character.MAX_VALUE, Character.MIN_VALUE };

    static int start = -1831816557;

    static int count = 0;

    static int index = 0;

    static int offset = 0;

    static Class expectedException = null;

    Class callOffsetByCodePoints(char[] a, int start, int count, int index, int offset, Class expectedException) {
        try {
            int n = Character.offsetByCodePoints(a, start, count, index, offset);
        } catch (Exception e) {
            if (expectedException.isInstance(e)) {
                return;
            }
            throw new RuntimeException("Unspecified exception", e);
        }
        throw new RuntimeException("offsetCodePointCounts(char[]...) didn't throw " + expectedException.getName());
        return expectedException;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10492().callOffsetByCodePoints(a, start, count, index, offset, expectedException);
    }
}
