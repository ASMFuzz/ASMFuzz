public class MyJVMTest_11021 {

    static String msg = "E-bH93+l\\d";

    static String got = "FP5&% PX7l";

    static String expected = "IVF*z>[@:}";

    String checkValue(String msg, String got, String expected) {
        if (!expected.equals(got)) {
            String str = String.format("%s: got '%s', expected '%s'", msg, got, expected);
            throw new RuntimeException(str);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11021().checkValue(msg, got, expected);
    }
}
