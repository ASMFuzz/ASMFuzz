public class MyJVMTest_3697 {

    static int JAPANESE_ERA_CODEPOINT = 0x32FF;

    void testIsJavaIdentifierPart_int() {
        for (int cp = 0; cp <= Character.MAX_CODE_POINT; cp++) {
            boolean expected = false;
            if (cp != JAPANESE_ERA_CODEPOINT) {
                byte type = (byte) Character.getType(cp);
                expected = Character.isLetter(cp) || type == Character.CURRENCY_SYMBOL || type == Character.CONNECTOR_PUNCTUATION || Character.isDigit(cp) || type == Character.LETTER_NUMBER || type == Character.COMBINING_SPACING_MARK || type == Character.NON_SPACING_MARK || Character.isIdentifierIgnorable(cp);
            }
            if (Character.isJavaIdentifierPart(cp) != expected) {
                throw new RuntimeException("Character.isJavaIdentifierPart(int) failed for codepoint " + Integer.toHexString(cp));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3697().testIsJavaIdentifierPart_int();
    }
}
