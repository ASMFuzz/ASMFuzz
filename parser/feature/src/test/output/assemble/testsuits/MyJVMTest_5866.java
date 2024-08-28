public class MyJVMTest_5866 {

    static int start = 0;

    static int end = 7;

    static char[] buffer = { '3', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, 'e', Character.MAX_VALUE, Character.MIN_VALUE, '0', '+' };

    static int index = 7;

    static int count = 0;

    static boolean shared = false;

    static char[] value = {Character.MIN_VALUE,'0',Character.MAX_VALUE,Character.MAX_VALUE,'0','k',Character.MIN_VALUE,'H','0','D'};

    int getChars(int start, int end, char[] buffer, int index) {
        try {
            if (start < count && end <= count) {
                System.arraycopy(value, start, buffer, index, end - start);
                return;
            }
        } catch (IndexOutOfBoundsException e) {
        }
        throw new IndexOutOfBoundsException();
        return start;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5866().getChars(start, end, buffer, index);
    }
}
