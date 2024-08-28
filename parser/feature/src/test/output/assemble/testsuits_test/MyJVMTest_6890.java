public class MyJVMTest_6890 {

    static short[] array = { -32768, -32768, -32768, 22921, 32111, 32767, 16341, 0, 32767, -1512 };

    short[] test(short[] array) {
        array[0] = 1;
        array[array.length - 1] = 1;
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6890().test(array);
    }
}
