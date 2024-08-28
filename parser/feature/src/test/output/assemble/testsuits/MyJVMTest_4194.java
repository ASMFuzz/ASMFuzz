public class MyJVMTest_4194 {

    static char c = 'u';

    boolean isWhitespace(char c) {
        return c == '\r' || c == '\n' || c == '\t' || c == ' ';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4194().isWhitespace(c));
    }
}
