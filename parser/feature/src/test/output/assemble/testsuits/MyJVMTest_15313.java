public class MyJVMTest_15313 {

    static int start = 5;

    static int end = 2;

    static char[] buffer = { Character.MIN_VALUE, '0', Character.MIN_VALUE, '0', Character.MAX_VALUE, '0', '8', Character.MAX_VALUE, '<', Character.MAX_VALUE };

    static int index = -1213761420;

    static int count = 0;

    static boolean shared = false;

    static char[] value = {'t','q',Character.MIN_VALUE,Character.MIN_VALUE,'0','m','6','0',Character.MAX_VALUE,Character.MAX_VALUE};

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
        new MyJVMTest_15313().getChars(start, end, buffer, index);
    }
}
