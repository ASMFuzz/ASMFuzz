public class MyJVMTest_13557 {

    static char c = '0';

    boolean isWhitespace(char c) {
        return c == '\r' || c == '\n' || c == '\t' || c == ' ';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13557().isWhitespace(c));
    }
}
