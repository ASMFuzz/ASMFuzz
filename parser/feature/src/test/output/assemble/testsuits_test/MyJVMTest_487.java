public class MyJVMTest_487 {

    static int codePoint = 1;

    static char[] dst = { Character.MAX_VALUE, '*', ';', Character.MIN_VALUE, 'j', Character.MIN_VALUE, '0', Character.MAX_VALUE, 'A', '0' };

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
        new MyJVMTest_487().callToChars3(codePoint, dst, index, expectedException);
    }
}
