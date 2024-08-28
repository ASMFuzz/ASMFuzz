public class MyJVMTest_13902 {

    static int mismatchIdx = 0;

    static String str1 = "dZX{M:jpE(";

    static String str2 = "cMSPr40B$M";

    static String caseName = "IgbN_WK#Lo";

    static int size = 1;

    String checkCase(int mismatchIdx, String str1, String str2, String caseName) {
        int expected;
        if (mismatchIdx != size) {
            expected = str1.charAt(mismatchIdx) - str2.charAt(mismatchIdx);
        } else {
            expected = str1.length() - str2.length();
        }
        int result = str1.compareTo(str2);
        int reversedResult = str2.compareTo(str1);
        if (expected != result || result != -reversedResult) {
            throw new AssertionError(String.format("%s CASE FAILED: size = %d, " + "mismatchIdx = %d, expected = %d, but got result = %d, " + "reversedResult = %d for string1 = '%s', string2 = '%s'", caseName, size, mismatchIdx, expected, result, reversedResult, str1, str2));
        }
        return str2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13902().checkCase(mismatchIdx, str1, str2, caseName);
    }
}
