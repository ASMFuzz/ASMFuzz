public class MyJVMTest_2636 {

    static String s = "0|EvbVP];=";

    static int codePoint = -580644;

    static String name = "QKLogn(T|;";

    static byte generalCategory = -84;

    static byte bidiCategory = -128;

    static int decimalValue = -1558137155;

    static int digitValue = -1079911583;

    static String numericValue = " 8V]s`\"rw}";

    static boolean mirrored = false;

    static String oldName = "[}Jn{$>&Q0";

    static String comment = "Zeu;D8^8 ^";

    static int upperMap = 5;

    static int lowerMap = -1834089757;

    static int titleMap = 5;

    static byte UNASSIGNED = 0, UPPERCASE_LETTER = 1, LOWERCASE_LETTER = 2, TITLECASE_LETTER = 3, MODIFIER_LETTER = 4, OTHER_LETTER = 5, NON_SPACING_MARK = 6, ENCLOSING_MARK = 7, COMBINING_SPACING_MARK = 8, DECIMAL_DIGIT_NUMBER = 9, LETTER_NUMBER = 10, OTHER_NUMBER = 11, SPACE_SEPARATOR = 12, LINE_SEPARATOR = 13, PARAGRAPH_SEPARATOR = 14, CONTROL = 15, FORMAT = 16, PRIVATE_USE = 18, SURROGATE = 19, DASH_PUNCTUATION = 20, START_PUNCTUATION = 21, END_PUNCTUATION = 22, CONNECTOR_PUNCTUATION = 23, OTHER_PUNCTUATION = 24, MATH_SYMBOL = 25, CURRENCY_SYMBOL = 26, MODIFIER_SYMBOL = 27, OTHER_SYMBOL = 28, INITIAL_QUOTE_PUNCTUATION = 29, FINAL_QUOTE_PUNCTUATION = 30, GENERAL_CATEGORY_COUNT = 31;

    static byte SHORT = 0, LONG = 1;

    static byte DIRECTIONALITY_UNDEFINED = -1, DIRECTIONALITY_LEFT_TO_RIGHT = 0, DIRECTIONALITY_RIGHT_TO_LEFT = 1, DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC = 2, DIRECTIONALITY_EUROPEAN_NUMBER = 3, DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR = 4, DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR = 5, DIRECTIONALITY_ARABIC_NUMBER = 6, DIRECTIONALITY_COMMON_NUMBER_SEPARATOR = 7, DIRECTIONALITY_NONSPACING_MARK = 8, DIRECTIONALITY_BOUNDARY_NEUTRAL = 9, DIRECTIONALITY_PARAGRAPH_SEPARATOR = 10, DIRECTIONALITY_SEGMENT_SEPARATOR = 11, DIRECTIONALITY_WHITESPACE = 12, DIRECTIONALITY_OTHER_NEUTRALS = 13, DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING = 14, DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE = 15, DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING = 16, DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE = 17, DIRECTIONALITY_POP_DIRECTIONAL_FORMAT = 18, DIRECTIONALITY_LEFT_TO_RIGHT_ISOLATE = 19, DIRECTIONALITY_RIGHT_TO_LEFT_ISOLATE = 20, DIRECTIONALITY_FIRST_STRONG_ISOLATE = 21, DIRECTIONALITY_POP_DIRECTIONAL_ISOLATE = 22, DIRECTIONALITY_CATEGORY_COUNT = 23;

    static String[][] bidiCategoryList = { { "L", "DIRECTIONALITY_LEFT_TO_RIGHT" }, { "R", "DIRECTIONALITY_RIGHT_TO_LEFT" }, { "AL", "DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC" }, { "EN", "DIRECTIONALITY_EUROPEAN_NUMBER" }, { "ES", "DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR" }, { "ET", "DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR" }, { "AN", "DIRECTIONALITY_ARABIC_NUMBER" }, { "CS", "DIRECTIONALITY_COMMON_NUMBER_SEPARATOR" }, { "NSM", "DIRECTIONALITY_NONSPACING_MARK" }, { "BN", "DIRECTIONALITY_BOUNDARY_NEUTRAL" }, { "B", "DIRECTIONALITY_PARAGRAPH_SEPARATOR" }, { "S", "DIRECTIONALITY_SEGMENT_SEPARATOR" }, { "WS", "DIRECTIONALITY_WHITESPACE" }, { "ON", "DIRECTIONALITY_OTHER_NEUTRALS" }, { "LRE", "DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING" }, { "LRO", "DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE" }, { "RLE", "DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING" }, { "RLO", "DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE" }, { "PDF", "DIRECTIONALITY_POP_DIRECTIONAL_FORMAT" }, { "LRI", "DIRECTIONALITY_LEFT_TO_RIGHT_ISOLATE" }, { "RLI", "DIRECTIONALITY_RIGHT_TO_LEFT_ISOLATE" }, { "FSI", "DIRECTIONALITY_FIRST_STRONG_ISOLATE" }, { "PDI", "DIRECTIONALITY_POP_DIRECTIONAL_ISOLATE" } };

    byte parseBidiCategory(String s) throws Exception {
        byte category = DIRECTIONALITY_CATEGORY_COUNT;
        for (byte x = 0; x < bidiCategoryList.length; x++) {
            if (s.equals(bidiCategoryList[x][SHORT])) {
                category = x;
                break;
            }
        }
        if (category >= DIRECTIONALITY_CATEGORY_COUNT) {
            throw new Exception("Could not parse bidi category.");
        }
        return category;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2636().parseBidiCategory(s));
    }
}
