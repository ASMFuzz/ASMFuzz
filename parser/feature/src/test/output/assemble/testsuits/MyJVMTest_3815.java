public class MyJVMTest_3815 {

    static char b1 = '0';

    static char volatileField = Character.MIN_VALUE;

    static byte[] str = { 'f', 'o' };

    char test(char b1) {
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                }
            }
        }
        int i = 0;
        for (; i < str.length; i++) {
            final byte b = str[i];
            if (b == b1) {
                break;
            }
        }
        final char c = (char) (str[i] & 0xff);
        volatileField = c;
        final char c2 = (char) (str[i] & 0xff);
        return c2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3815().test(b1));
    }
}
