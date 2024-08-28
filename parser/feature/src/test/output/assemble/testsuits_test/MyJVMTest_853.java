public class MyJVMTest_853 {

    static String str = "Av]jOsT!Jv";

    static char[] buffer = { Character.MAX_VALUE, 'q', '0', 'W', Character.MIN_VALUE, '?', Character.MAX_VALUE, Character.MIN_VALUE, '0', 'c' };

    static int size = 9;

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
        new MyJVMTest_853().reverse(str, buffer, size);
    }
}
