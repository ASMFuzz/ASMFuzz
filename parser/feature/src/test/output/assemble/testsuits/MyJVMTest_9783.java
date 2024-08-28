public class MyJVMTest_9783 {

    static char c1 = Character.MIN_VALUE;

    static char c2 = '0';

    String getLongString(char c1, char c2) {
        char[] chars = new char[c2 - c1 + 1];
        for (char i = c1; i <= c2; i++) {
            chars[i - c1] = i;
        }
        return new String(chars);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9783().getLongString(c1, c2));
    }
}
