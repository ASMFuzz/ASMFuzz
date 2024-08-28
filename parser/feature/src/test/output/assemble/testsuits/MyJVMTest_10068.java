public class MyJVMTest_10068 {

    static int JAPANESE_ERA_CODEPOINT = 0x32FF;

    void testIsJavaIdentifierStart_int() {
        for (int cp = 0; cp <= Character.MAX_CODE_POINT; cp++) {
            boolean expected = false;
            if (cp != JAPANESE_ERA_CODEPOINT) {
                byte type = (byte) Character.getType(cp);
                expected = Character.isLetter(cp) || type == Character.LETTER_NUMBER || type == Character.CURRENCY_SYMBOL || type == Character.CONNECTOR_PUNCTUATION;
            }
            if (Character.isJavaIdentifierStart(cp) != expected) {
                throw new RuntimeException("Character.isJavaIdentifierStart(int) failed for codepoint " + Integer.toHexString(cp));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10068().testIsJavaIdentifierStart_int();
    }
}
