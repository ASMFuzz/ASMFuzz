public class MyJVMTest_15776 {

    static long[] array = new long[10];

    static byte[] byte_array = new byte[10];

    void array_init4() {
        for (int i = 0; i < 3; i++) {
            byte_array[i] = -1;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15776().array_init4();
    }
}
