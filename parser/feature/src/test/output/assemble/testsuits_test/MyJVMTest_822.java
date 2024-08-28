public class MyJVMTest_822 {

    static long[] array = { 0, -9188280526346934985L, -6332433107289450037L, 0, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 0, -9223372036854775808L, 9223372036854775807L };

    long[] test(long[] array) {
        array[0] = 1;
        array[array.length - 1] = 1;
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_822().test(array);
    }
}
