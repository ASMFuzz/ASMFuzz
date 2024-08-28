public class MyJVMTest_103 {

    static int ch = 1;

    boolean isNoncharacterCodePoint(int ch) {
        return (ch & 0xfffe) == 0xfffe || (ch >= 0xfdd0 && ch <= 0xfdef);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_103().isNoncharacterCodePoint(ch));
    }
}
