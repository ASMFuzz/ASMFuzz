import java.lang.invoke.*;

public class MyJVMTest_9370 {

    static String expected = "~aA:s6vE}*";

    static String actual = "NU%^Sw[=sx";

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
        new MyJVMTest_9370().test(expected, actual);
    }
}
