public class MyJVMTest_12532 {

    static int ch = 8;

    boolean isSpace(int ch) {
        return ((((1 << Character.SPACE_SEPARATOR) | (1 << Character.LINE_SEPARATOR) | (1 << Character.PARAGRAPH_SEPARATOR)) >> Character.getType(ch)) & 1) != 0 || (ch >= 0x9 && ch <= 0xd) || (ch == 0x85);
    }

    boolean isGraph(int ch) {
        int type = Character.getType(ch);
        return !(isSpace(ch) || Character.CONTROL == type || Character.SURROGATE == type || Character.UNASSIGNED == type);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12532().isGraph(ch));
    }
}
