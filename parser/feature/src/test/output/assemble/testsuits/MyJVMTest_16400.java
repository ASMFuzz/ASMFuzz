public class MyJVMTest_16400 {

    static short[] array = { 32767, -32768, -32768, 32767, 0, -19742, 0, -32768, 0, 32767 };

    short[] test(short[] array) {
        array[0] = 1;
        array[array.length - 1] = 1;
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16400().test(array);
    }
}
