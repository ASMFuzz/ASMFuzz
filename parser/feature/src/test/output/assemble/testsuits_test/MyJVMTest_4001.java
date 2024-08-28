public class MyJVMTest_4001 {

    static int ch = 5;

    static int radix = 2;

    int canonicalDigit(int ch, int radix) {
        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
            return -1;
        }
        if (ch >= '0' && ch <= '9' && ch < (radix + '0')) {
            return ch - '0';
        }
        if (ch >= 'A' && ch <= 'Z' && ch < (radix + 'A' - 10)) {
            return ch - 'A' + 10;
        }
        if (ch >= 'a' && ch <= 'z' && ch < (radix + 'a' - 10)) {
            return ch - 'a' + 10;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4001().canonicalDigit(ch, radix));
    }
}
