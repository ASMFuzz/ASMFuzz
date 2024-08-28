public class MyJVMTest_6269 {

    static String message = "!n@Y819\"ZH";

    static int pos = 0;

    static String input = "sFpE(:n'<i";

    IllegalStateException failure(String message) {
        return new IllegalStateException(String.format("[%d]: %s : %s", pos, message, input));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6269().failure(message));
    }
}
