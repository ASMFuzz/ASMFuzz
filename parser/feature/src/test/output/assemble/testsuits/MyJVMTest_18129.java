public class MyJVMTest_18129 {

    static int min = 8;

    void ensureCapacityImpl(int min) {
        int twice = (value.length << 1) + 2;
        char[] newData = new char[min > twice ? min : twice];
        System.arraycopy(value, 0, newData, 0, count);
        value = newData;
        shared = false;
    }

    static int count = 0;

    static boolean shared = true;

    static char[] value = {'0',Character.MIN_VALUE,'0','0',Character.MIN_VALUE,'0',Character.MAX_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,Character.MAX_VALUE};

    int ensureCapacity(int min) {
        if (min > value.length)
            ensureCapacityImpl(min);
        return min;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18129().ensureCapacity(min);
    }
}
