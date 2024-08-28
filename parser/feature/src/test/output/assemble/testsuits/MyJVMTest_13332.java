public class MyJVMTest_13332 {

    static int ch = 2;

    boolean isSpace(int ch) {
        return ((((1 << Character.SPACE_SEPARATOR) | (1 << Character.LINE_SEPARATOR) | (1 << Character.PARAGRAPH_SEPARATOR)) >> Character.getType(ch)) & 1) != 0 || (ch >= 0x9 && ch <= 0xd) || (ch == 0x85);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13332().isSpace(ch));
    }
}
