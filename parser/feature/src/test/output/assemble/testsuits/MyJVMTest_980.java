public class MyJVMTest_980 {

    static String message = "5e(h}!x\\x%";

    boolean hasInput() {
        return pos < input.length();
    }

    IllegalStateException failure(String message) {
        return new IllegalStateException(String.format("[%d]: %s : %s", pos, message, input));
    }

    static int pos = 0;

    static String input = "[2+hhXJ5M3";

    String expectMoreInput(String message) {
        if (!hasInput()) {
            throw failure(message);
        }
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_980().expectMoreInput(message);
    }
}
