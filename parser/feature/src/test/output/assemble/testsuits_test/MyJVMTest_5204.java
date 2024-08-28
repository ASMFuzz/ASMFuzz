public class MyJVMTest_5204 {

    static String str = "?oyfs'.w$n";

    void reverse(String str, char[] buffer, int size) {
        str.getChars(0, size, buffer, 0);
        int half = size / 2;
        for (int l = 0, r = size - 1; l < half; l++, r--) {
            char tmp = buffer[l];
            buffer[l] = buffer[r];
            buffer[r] = tmp;
        }
    }

    String reverseString(String str) {
        int size = str.length();
        char[] buffer = new char[size];
        reverse(str, buffer, size);
        return new String(buffer, 0, size);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5204().reverseString(str));
    }
}
