public class MyJVMTest_7679 {

    static long[] array = new long[10];

    void array_init() {
        array[0] = -1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7679().array_init();
    }
}
