public class MyJVMTest_1288 {

    static char[] a = { 'A', '0', Character.MAX_VALUE, Character.MAX_VALUE, 'd', Character.MAX_VALUE, '0', '0', Character.MAX_VALUE, Character.MAX_VALUE };

    static int start = 9;

    static int count = 7;

    static int index = 2;

    static int offset = -1982193265;

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
        new MyJVMTest_1288().callOffsetByCodePoints(a, start, count, index, offset, expectedException);
    }
}
