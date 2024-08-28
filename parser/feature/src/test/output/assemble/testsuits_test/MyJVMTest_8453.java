public class MyJVMTest_8453 {

    static int size = 0;

    static int index = 1;

    static int count = 9;

    static boolean shared = true;

    static char[] value = {'0',Character.MAX_VALUE,'0','0',Character.MIN_VALUE,'0','0','0',Character.MIN_VALUE,'0'};

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
        new MyJVMTest_8453().move(size, index);
    }
}
