public class MyJVMTest_4648 {

    static CharSequence seq = null;

    static int index = 6;

    static int offset = 4;

    static Class expectedException = null;

    Class callOffsetByCodePoints(CharSequence seq, int index, int offset, Class expectedException) {
        try {
            int n = Character.offsetByCodePoints(seq, index, offset);
        } catch (Exception e) {
            if (expectedException.isInstance(e)) {
                return;
            }
            throw new RuntimeException("Unspecified exception", e);
        }
        throw new RuntimeException("offsetCodePointCounts(CharSequnce...) didn't throw " + expectedException.getName());
        return expectedException;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4648().callOffsetByCodePoints(seq, index, offset, expectedException);
    }
}
