public class MyJVMTest_6193 {

    static char ch = '0';

    static int _fCreationYear = 0;

    boolean isSpace(char ch) {
        return ch == ' ' || ch == '\t' || ch == '\r';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6193().isSpace(ch));
    }
}
