public class MyJVMTest_14228 {

    static long[] array = new long[10];

    void array_init2() {
        for (int i = 0; i < 6; i++) {
            array[i] = -1;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14228().array_init2();
    }
}
