public class MyJVMTest_5619 {

    static int n = 4;

    static int codePoint = 0;

    static String name = "6?/@j;a.!g";

    static byte generalCategory = -128;

    static byte bidiCategory = -128;

    static int decimalValue = -506092680;

    static int digitValue = 0;

    static String numericValue = "!-LjJv>E p";

    static boolean mirrored = true;

    static String oldName = "e;}fmA@.So";

    static String comment = "SFAdm9x#j<";

    static int upperMap = -1514736912;

    static int lowerMap = 5;

    static int titleMap = -193111072;

    static byte UNASSIGNED = 0, UPPERCASE_LETTER = 1, LOWERCASE_LETTER = 2, TITLECASE_LETTER = 3, MODIFIER_LETTER = 4, OTHER_LETTER = 5, NON_SPACING_MARK = 6, ENCLOSING_MARK = 7, COMBINING_SPACING_MARK = 8, DECIMAL_DIGIT_NUMBER = 9, LETTER_NUMBER = 10, OTHER_NUMBER = 11, SPACE_SEPARATOR = 12, LINE_SEPARATOR = 13, PARAGRAPH_SEPARATOR = 14, CONTROL = 15, FORMAT = 16, PRIVATE_USE = 18, SURROGATE = 19, DASH_PUNCTUATION = 20, START_PUNCTUATION = 21, END_PUNCTUATION = 22, CONNECTOR_PUNCTUATION = 23, OTHER_PUNCTUATION = 24, MATH_SYMBOL = 25, CURRENCY_SYMBOL = 26, MODIFIER_SYMBOL = 27, OTHER_SYMBOL = 28, INITIAL_QUOTE_PUNCTUATION = 29, FINAL_QUOTE_PUNCTUATION = 30, GENERAL_CATEGORY_COUNT = 31;

    static byte DIRECTIONALITY_UNDEFINED = -1, DIRECTIONALITY_LEFT_TO_RIGHT = 0, DIRECTIONALITY_RIGHT_TO_LEFT = 1, DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC = 2, DIRECTIONALITY_EUROPEAN_NUMBER = 3, DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR = 4, DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR = 5, DIRECTIONALITY_ARABIC_NUMBER = 6, DIRECTIONALITY_COMMON_NUMBER_SEPARATOR = 7, DIRECTIONALITY_NONSPACING_MARK = 8, DIRECTIONALITY_BOUNDARY_NEUTRAL = 9, DIRECTIONALITY_PARAGRAPH_SEPARATOR = 10, DIRECTIONALITY_SEGMENT_SEPARATOR = 11, DIRECTIONALITY_WHITESPACE = 12, DIRECTIONALITY_OTHER_NEUTRALS = 13, DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING = 14, DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE = 15, DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING = 16, DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE = 17, DIRECTIONALITY_POP_DIRECTIONAL_FORMAT = 18, DIRECTIONALITY_LEFT_TO_RIGHT_ISOLATE = 19, DIRECTIONALITY_RIGHT_TO_LEFT_ISOLATE = 20, DIRECTIONALITY_FIRST_STRONG_ISOLATE = 21, DIRECTIONALITY_POP_DIRECTIONAL_ISOLATE = 22, DIRECTIONALITY_CATEGORY_COUNT = 23;

    String hex4(int n) {
        String q = Long.toHexString(n & 0xFFFF).toUpperCase();
        return "0000".substring(Math.min(4, q.length())) + q;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5619().hex4(n));
    }
}
