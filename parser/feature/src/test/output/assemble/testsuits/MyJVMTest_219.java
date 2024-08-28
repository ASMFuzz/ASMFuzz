import java.lang.invoke.*;

public class MyJVMTest_219 {

    static String expected = "/!6PyV6XTF";

    static String actual = "N;|NUr6O{-";

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
        new MyJVMTest_219().test(expected, actual);
    }
}
