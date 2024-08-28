public class MyJVMTest_14129 {

    static String expected = "(^_o9`Iv|a";

    static String actual = "LyE)%(Ujos";

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
        new MyJVMTest_14129().test(expected, actual);
    }
}
