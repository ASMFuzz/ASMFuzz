public class MyJVMTest_16346 {

    static String str2 = ".F)L0a[y0)";

    static String str1 = ">xSF^U*(vA";

    static int expected = 0;

    static String caseName = "vR4Hw.R#2Z";

    static int size = 0;

    String checkCase(String str2, String str1, int expected, String caseName) {
        int result = str2.compareTo(str1);
        int reversedResult = str1.compareTo(str2);
        if (expected != result || result != -reversedResult) {
            throw new AssertionError(String.format("%s CASE FAILED: size = %d, " + "expected = %d, but got result = %d, " + "reversedResult = %d for string1 = '%s', string2 = '%s'", caseName, size, expected, result, reversedResult, str1, str2));
        }
        return str2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16346().checkCase(str2, str1, expected, caseName);
    }
}
