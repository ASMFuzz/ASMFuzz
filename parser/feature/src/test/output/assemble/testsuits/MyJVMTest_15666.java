public class MyJVMTest_15666 {

    static char ch = Character.MIN_VALUE;

    static int _fCreationYear = 8;

    boolean isSpace(char ch) {
        return ch == ' ' || ch == '\t' || ch == '\r';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15666().isSpace(ch));
    }
}
