public class MyJVMTest_10166 {

    static String message = "/m$Qx6+$M,";

    boolean hasInput() {
        return pos < input.length();
    }

    IllegalStateException failure(String message) {
        return new IllegalStateException(String.format("[%d]: %s : %s", pos, message, input));
    }

    static int pos = 0;

    static String input = "rnHy>j1J7+";

    String expectMoreInput(String message) {
        if (!hasInput()) {
            throw failure(message);
        }
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10166().expectMoreInput(message);
    }
}
