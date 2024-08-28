public class MyJVMTest_10001 {

    static long[] array = { -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 0, 0 };

    long[] test(long[] array) {
        array[0] = 1;
        array[array.length - 1] = 1;
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10001().test(array);
    }
}
