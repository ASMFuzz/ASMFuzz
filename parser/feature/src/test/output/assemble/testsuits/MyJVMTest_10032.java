public class MyJVMTest_10032 {

    static String str = "'B\\f02MO:5";

    static char[] buffer = { Character.MAX_VALUE, Character.MIN_VALUE, 'B', Character.MAX_VALUE, '0', '0', Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE };

    static int size = 0;

    char[] reverse(String str, char[] buffer, int size) {
        str.getChars(0, size, buffer, 0);
        int half = size / 2;
        for (int l = 0, r = size - 1; l < half; l++, r--) {
            char tmp = buffer[l];
            buffer[l] = buffer[r];
            buffer[r] = tmp;
        }
        return buffer;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10032().reverse(str, buffer, size);
    }
}
