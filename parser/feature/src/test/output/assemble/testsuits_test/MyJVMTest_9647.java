public class MyJVMTest_9647 {

    static int codePoint = 4;

    static char[] dst = { Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0', '8', '0', '0', Character.MIN_VALUE };

    static int index = 0;

    static Class expectedException = null;

    Class callToChars3(int codePoint, char[] dst, int index, Class expectedException) {
        try {
            int n = Character.toChars(codePoint, dst, index);
        } catch (Exception e) {
            if (expectedException.isInstance(e)) {
                return;
            }
            throw new RuntimeException("Unspecified exception", e);
        }
        throw new RuntimeException("toChars(int,char[],int) didn't throw " + expectedException.getName());
        return expectedException;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9647().callToChars3(codePoint, dst, index, expectedException);
    }
}
