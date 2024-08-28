public class MyJVMTest_5104 {

    static int ch = 3;

    boolean isAlpha(int ch) {
        return Character.isAlphabetic(ch);
    }

    boolean isDigit(int ch) {
        return Character.isDigit(ch);
    }

    boolean isJoinControl(int ch) {
        return (ch == 0x200C || ch == 0x200D);
    }

    boolean isWord(int ch) {
        return isAlpha(ch) || ((((1 << Character.NON_SPACING_MARK) | (1 << Character.ENCLOSING_MARK) | (1 << Character.COMBINING_SPACING_MARK) | (1 << Character.CONNECTOR_PUNCTUATION)) >> Character.getType(ch)) & 1) != 0 || isDigit(ch) || isJoinControl(ch);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5104().isWord(ch));
    }
}
