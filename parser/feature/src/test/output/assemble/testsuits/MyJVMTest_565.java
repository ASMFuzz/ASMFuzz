public class MyJVMTest_565 {

    static int length = 0;

    void ensureCapacityImpl(int min) {
        int twice = (value.length << 1) + 2;
        char[] newData = new char[min > twice ? min : twice];
        System.arraycopy(value, 0, newData, 0, count);
        value = newData;
        shared = false;
    }

    static int count = 700839512;

    static boolean shared = true;

    static char[] value = {':','0',Character.MAX_VALUE,Character.MIN_VALUE,'Y','0','0',Character.MIN_VALUE,Character.MAX_VALUE,Character.MIN_VALUE};

    int setLength(int length) {
        if (length > value.length)
            ensureCapacityImpl(length);
        if (count > length) {
            if (!shared) {
                try {
                    for (int i = length; i < count; i++) value[i] = 0;
                } catch (IndexOutOfBoundsException e) {
                    throw new IndexOutOfBoundsException();
                }
            } else {
                char[] newData = new char[value.length];
                System.arraycopy(value, 0, newData, 0, length);
                value = newData;
                shared = false;
            }
        }
        count = length;
        return length;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_565().setLength(length);
    }
}
