public class MyJVMTest_17231 {

    static long[] array = new long[10];

    void array_init() {
        array[0] = -1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17231().array_init();
    }
}
