public class MyJVMTest_9629 {

    static int JAPANESE_ERA_CODEPOINT = 0x32FF;

    void testIsJavaIdentifierStart_char() {
        for (int i = 0; i <= Character.MAX_VALUE; i++) {
            char ch = (char) i;
            boolean expected = false;
            if (i != JAPANESE_ERA_CODEPOINT) {
                byte type = (byte) Character.getType(ch);
                expected = Character.isLetter(ch) || type == Character.LETTER_NUMBER || type == Character.CURRENCY_SYMBOL || type == Character.CONNECTOR_PUNCTUATION;
            }
            if (Character.isJavaIdentifierStart(ch) != expected) {
                throw new RuntimeException("Character.isJavaIdentifierStart(char) failed for codepoint " + Integer.toHexString(i));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9629().testIsJavaIdentifierStart_char();
    }
}
