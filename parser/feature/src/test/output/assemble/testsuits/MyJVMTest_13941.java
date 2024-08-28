public class MyJVMTest_13941 {

    static int JAPANESE_ERA_CODEPOINT = 0x32FF;

    void testIsJavaIdentifierPart_char() {
        for (int i = 0; i <= Character.MAX_VALUE; ++i) {
            char ch = (char) i;
            boolean expected = false;
            if (i != JAPANESE_ERA_CODEPOINT) {
                byte type = (byte) Character.getType(ch);
                expected = Character.isLetter(ch) || type == Character.CURRENCY_SYMBOL || type == Character.CONNECTOR_PUNCTUATION || Character.isDigit(ch) || type == Character.LETTER_NUMBER || type == Character.COMBINING_SPACING_MARK || type == Character.NON_SPACING_MARK || Character.isIdentifierIgnorable(ch);
            }
            if (Character.isJavaIdentifierPart((char) i) != expected) {
                throw new RuntimeException("Character.isJavaIdentifierPart(char) failed for codepoint " + Integer.toHexString(i));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13941().testIsJavaIdentifierPart_char();
    }
}
