public class MyJVMTest_15745 {

    static String message = ")PdYi$DU):";

    static int pos = 0;

    static String input = "Qz1+*GO{Uw";

    IllegalStateException failure(String message) {
        return new IllegalStateException(String.format("[%d]: %s : %s", pos, message, input));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15745().failure(message));
    }
}
