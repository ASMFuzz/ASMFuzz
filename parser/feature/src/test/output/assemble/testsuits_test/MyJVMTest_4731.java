public class MyJVMTest_4731 {

    static String expected = "t~Lgr|}Fo1";

    static String actual = "fi[~5 jZv0";

    static String s = "f";

    static int i = 7;

    String test(String expected, String actual) {
        if (!expected.equals(actual)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected = ");
            sb.append(expected);
            sb.append(", actual = ");
            sb.append(actual);
            throw new IllegalStateException(sb.toString());
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4731().test(expected, actual);
    }
}
