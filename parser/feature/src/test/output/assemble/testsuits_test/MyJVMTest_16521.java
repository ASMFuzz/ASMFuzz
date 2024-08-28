public class MyJVMTest_16521 {

    static short[] a1 = new short[8];

    static short[] a2 = new short[8];

    static short[] a3 = new short[8];

    void run() {
        for (int i = 0; i < 1000000; i++) {
            System.arraycopy(a2, 5, a1, 3, 3);
            System.arraycopy(a3, 5, a1, 3, 3);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16521().run();
    }
}
