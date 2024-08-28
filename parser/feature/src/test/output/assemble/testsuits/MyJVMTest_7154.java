public class MyJVMTest_7154 {

    static int min = 1;

    static int count = 0;

    static boolean shared = true;

    static char[] value = {Character.MIN_VALUE,'0','0',Character.MAX_VALUE,'0','0','$','0',Character.MAX_VALUE,'0'};

    char[] ensureCapacityImpl(int min) {
        int twice = (value.length << 1) + 2;
        char[] newData = new char[min > twice ? min : twice];
        System.arraycopy(value, 0, newData, 0, count);
        value = newData;
        shared = false;
        return newData;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7154().ensureCapacityImpl(min);
    }
}
