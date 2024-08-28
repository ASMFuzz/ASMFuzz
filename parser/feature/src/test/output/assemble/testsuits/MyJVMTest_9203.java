public class MyJVMTest_9203 {

    static int index = 0;

    static String buffer = " c7Kc6+ps:";

    void skipWhitespace() {
        while ((index < buffer.length()) && Character.isWhitespace(buffer.charAt(index))) {
            index++;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9203().skipWhitespace();
    }
}
