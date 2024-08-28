public class MyJVMTest_61 {

    static int index = 0;

    static String buffer = "A3h;=F%^J8";

    void skipWhitespace() {
        while ((index < buffer.length()) && Character.isWhitespace(buffer.charAt(index))) {
            index++;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_61().skipWhitespace();
    }
}
