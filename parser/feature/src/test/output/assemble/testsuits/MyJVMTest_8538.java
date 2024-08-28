public class MyJVMTest_8538 {

    static int min = 8;

    void ensureCapacityImpl(int min) {
        int twice = (value.length << 1) + 2;
        char[] newData = new char[min > twice ? min : twice];
        System.arraycopy(value, 0, newData, 0, count);
        value = newData;
        shared = false;
    }

    static int count = 0;

    static boolean shared = false;

    static char[] value = {Character.MIN_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,'0','c',Character.MIN_VALUE,'0','!'};

    int ensureCapacity(int min) {
        if (min > value.length)
            ensureCapacityImpl(min);
        return min;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8538().ensureCapacity(min);
    }
}
