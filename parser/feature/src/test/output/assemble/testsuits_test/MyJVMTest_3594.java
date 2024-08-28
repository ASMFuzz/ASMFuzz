public class MyJVMTest_3594 {

    static long[] array = new long[10];

    void array_init3() {
        for (int i = 0; i < 3; i++) {
            array[i] = -1;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3594().array_init3();
    }
}
