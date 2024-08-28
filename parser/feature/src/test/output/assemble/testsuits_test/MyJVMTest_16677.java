public class MyJVMTest_16677 {

    static int min = -1467396836;

    static int count = 1888758095;

    static boolean shared = false;

    static char[] value = {'}','0',Character.MIN_VALUE,'%','a',Character.MIN_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,'l'};

    char[] ensureCapacityImpl(int min) {
        int twice = (value.length << 1) + 2;
        char[] newData = new char[min > twice ? min : twice];
        System.arraycopy(value, 0, newData, 0, count);
        value = newData;
        shared = false;
        return newData;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16677().ensureCapacityImpl(min);
    }
}
