public class MyJVMTest_18041 {

    static int ch = 7;

    boolean isDigit(int ch) {
        return Character.isDigit(ch);
    }

    boolean isHexDigit(int ch) {
        return Character.isDigit(ch) || (ch >= 0x0030 && ch <= 0x0039) || (ch >= 0x0041 && ch <= 0x0046) || (ch >= 0x0061 && ch <= 0x0066) || (ch >= 0xFF10 && ch <= 0xFF19) || (ch >= 0xFF21 && ch <= 0xFF26) || (ch >= 0xFF41 && ch <= 0xFF46);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18041().isHexDigit(ch));
    }
}
