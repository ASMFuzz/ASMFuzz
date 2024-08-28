public class MyJVMTest_7501 {

    static String message = ";0(-yT~eR#";

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

    static String input = "<1gpB2sZ[N";

    char next(String message) {
        advance();
        if (!hasInput()) {
            throw failure(message);
        }
        return current();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7501().next(message));
    }
}
