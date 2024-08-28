public class MyJVMTest_9731 {

    static int length = 949542350;

    void ensureCapacityImpl(int min) {
        int twice = (value.length << 1) + 2;
        char[] newData = new char[min > twice ? min : twice];
        System.arraycopy(value, 0, newData, 0, count);
        value = newData;
        shared = false;
    }

    static int count = 0;

    static boolean shared = false;

    static char[] value = {Character.MIN_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,'!','0','0',Character.MIN_VALUE,'2',Character.MIN_VALUE};

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
        new MyJVMTest_9731().setLength(length);
    }
}
