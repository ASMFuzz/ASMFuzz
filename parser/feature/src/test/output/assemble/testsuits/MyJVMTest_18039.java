public class MyJVMTest_18039 {

    static int size = 1318350425;

    static int index = 0;

    static int count = 1;

    static boolean shared = false;

    static char[] value = {'4','+','A','J',Character.MIN_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,Character.MIN_VALUE};

    int move(int size, int index) {
        if (0 <= index && index <= count) {
            int newSize;
            if (value.length - count >= size) {
                if (!shared) {
                    System.arraycopy(value, index, value, index + size, count - index);
                    return;
                }
                newSize = value.length;
            } else {
                int a = count + size, b = (value.length << 1) + 2;
                newSize = a > b ? a : b;
            }
            char[] newData = new char[newSize];
            System.arraycopy(value, 0, newData, 0, index);
            System.arraycopy(value, index, newData, index + size, count - index);
            value = newData;
            shared = false;
        } else
            throw new IndexOutOfBoundsException();
        return index;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18039().move(size, index);
    }
}
