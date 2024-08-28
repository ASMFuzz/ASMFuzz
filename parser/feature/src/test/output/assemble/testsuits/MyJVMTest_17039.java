public class MyJVMTest_17039 {

    static String message = "&N9FW`{}'w";

    void advance() {
        pos++;
    }

    boolean hasInput() {
        return pos < input.length();
    }

    IllegalStateException failure(String message) {
        return new IllegalStateException(String.format("[%d]: %s : %s", pos, message, input));
    }

    char current() {
        return input.charAt(pos);
    }

    static int pos = 0;

    static String input = "d8P/{G| =$";

    char next(String message) {
        advance();
        if (!hasInput()) {
            throw failure(message);
        }
        return current();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17039().next(message));
    }
}
