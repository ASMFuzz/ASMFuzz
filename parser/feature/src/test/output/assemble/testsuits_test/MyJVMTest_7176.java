public class MyJVMTest_7176 {

    static String s = "5|&>HvQy)%";

    static int codePoint = 7;

    static String name = "_LU9ONchdc";

    static byte generalCategory = 0;

    static byte bidiCategory = -100;

    static int decimalValue = 2006540979;

    static int digitValue = 9;

    static String numericValue = "d=!&%+.0K6";

    static boolean mirrored = false;

    static String oldName = "P2('\\q9^@O";

    static String comment = "|GhlCV=\\8b";

    static int upperMap = 779001731;

    static int lowerMap = 215774597;

    static int titleMap = 1758242832;

    static byte UNASSIGNED = 0, UPPERCASE_LETTER = 1, LOWERCASE_LETTER = 2, TITLECASE_LETTER = 3, MODIFIER_LETTER = 4, OTHER_LETTER = 5, NON_SPACING_MARK = 6, ENCLOSING_MARK = 7, COMBINING_SPACING_MARK = 8, DECIMAL_DIGIT_NUMBER = 9, LETTER_NUMBER = 10, OTHER_NUMBER = 11, SPACE_SEPARATOR = 12, LINE_SEPARATOR = 13, PARAGRAPH_SEPARATOR = 14, CONTROL = 15, FORMAT = 16, PRIVATE_USE = 18, SURROGATE = 19, DASH_PUNCTUATION = 20, START_PUNCTUATION = 21, END_PUNCTUATION = 22, CONNECTOR_PUNCTUATION = 23, OTHER_PUNCTUATION = 24, MATH_SYMBOL = 25, CURRENCY_SYMBOL = 26, MODIFIER_SYMBOL = 27, OTHER_SYMBOL = 28, INITIAL_QUOTE_PUNCTUATION = 29, FINAL_QUOTE_PUNCTUATION = 30, GENERAL_CATEGORY_COUNT = 31;

    static byte SHORT = 0, LONG = 1;

    static String[][] generalCategoryList = { { "Cn", "UNASSIGNED" }, { "Lu", "UPPERCASE_LETTER" }, { "Ll", "LOWERCASE_LETTER" }, { "Lt", "TITLECASE_LETTER" }, { "Lm", "MODIFIER_LETTER" }, { "Lo", "OTHER_LETTER" }, { "Mn", "NON_SPACING_MARK" }, { "Me", "ENCLOSING_MARK" }, { "Mc", "COMBINING_SPACING_MARK" }, { "Nd", "DECIMAL_DIGIT_NUMBER" }, { "Nl", "LETTER_NUMBER" }, { "No", "OTHER_NUMBER" }, { "Zs", "SPACE_SEPARATOR" }, { "Zl", "LINE_SEPARATOR" }, { "Zp", "PARAGRAPH_SEPARATOR" }, { "Cc", "CONTROL" }, { "Cf", "FORMAT" }, { "xx", "unused" }, { "Co", "PRIVATE_USE" }, { "Cs", "SURROGATE" }, { "Pd", "DASH_PUNCTUATION" }, { "Ps", "START_PUNCTUATION" }, { "Pe", "END_PUNCTUATION" }, { "Pc", "CONNECTOR_PUNCTUATION" }, { "Po", "OTHER_PUNCTUATION" }, { "Sm", "MATH_SYMBOL" }, { "Sc", "CURRENCY_SYMBOL" }, { "Sk", "MODIFIER_SYMBOL" }, { "So", "OTHER_SYMBOL" }, { "Pi", "INITIAL_QUOTE_PUNCTUATION" }, { "Pf", "FINAL_QUOTE_PUNCTUATION" } };

    static byte DIRECTIONALITY_UNDEFINED = -1, DIRECTIONALITY_LEFT_TO_RIGHT = 0, DIRECTIONALITY_RIGHT_TO_LEFT = 1, DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC = 2, DIRECTIONALITY_EUROPEAN_NUMBER = 3, DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR = 4, DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR = 5, DIRECTIONALITY_ARABIC_NUMBER = 6, DIRECTIONALITY_COMMON_NUMBER_SEPARATOR = 7, DIRECTIONALITY_NONSPACING_MARK = 8, DIRECTIONALITY_BOUNDARY_NEUTRAL = 9, DIRECTIONALITY_PARAGRAPH_SEPARATOR = 10, DIRECTIONALITY_SEGMENT_SEPARATOR = 11, DIRECTIONALITY_WHITESPACE = 12, DIRECTIONALITY_OTHER_NEUTRALS = 13, DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING = 14, DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE = 15, DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING = 16, DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE = 17, DIRECTIONALITY_POP_DIRECTIONAL_FORMAT = 18, DIRECTIONALITY_LEFT_TO_RIGHT_ISOLATE = 19, DIRECTIONALITY_RIGHT_TO_LEFT_ISOLATE = 20, DIRECTIONALITY_FIRST_STRONG_ISOLATE = 21, DIRECTIONALITY_POP_DIRECTIONAL_ISOLATE = 22, DIRECTIONALITY_CATEGORY_COUNT = 23;

    byte parseGeneralCategory(String s) throws Exception {
        byte category = GENERAL_CATEGORY_COUNT;
        for (byte x = 0; x < generalCategoryList.length; x++) {
            if (s.equals(generalCategoryList[x][SHORT])) {
                category = x;
                break;
            }
        }
        if (category >= GENERAL_CATEGORY_COUNT) {
            throw new Exception("Could not parse general category.");
        }
        return category;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7176().parseGeneralCategory(s));
    }
}
