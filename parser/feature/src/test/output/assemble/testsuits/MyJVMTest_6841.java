public class MyJVMTest_6841 {

    static String str2 = "]X.Ar1*j>v";

    static String str1 = "(h5\"qJ*]s,";

    static int expected = 0;

    static String caseName = "Cw*stuuY3n";

    static int size = 3;

    String checkCase(String str2, String str1, int expected, String caseName) {
        int result = str2.compareTo(str1);
        int reversedResult = str1.compareTo(str2);
        if (expected != result || result != -reversedResult) {
            throw new AssertionError(String.format("%s CASE FAILED: size = %d, " + "expected = %d, but got result = %d, " + "reversedResult = %d for string1 = '%s', string2 = '%s'", caseName, size, expected, result, reversedResult, str1, str2));
        }
        return str2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6841().checkCase(str2, str1, expected, caseName);
    }
}
