public class MyJVMTest_11395 {

    static int ch = 5;

    static int radix = 0;

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

    int test(int ch, int radix) throws Exception {
        int d1 = Character.digit(ch, radix);
        int d2 = canonicalDigit(ch, radix);
        if (d1 != d2) {
            throw new Exception("Wrong result for char=" + ch + " (" + (char) ch + "), radix=" + radix + "; " + d1 + " != " + d2);
        }
        return ch;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11395().test(ch, radix);
    }
}
