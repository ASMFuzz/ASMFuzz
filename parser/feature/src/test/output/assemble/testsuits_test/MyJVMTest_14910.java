public class MyJVMTest_14910 {

    static short[] a1 = new short[8];

    static boolean keepRunning = true;

    void run() {
        while (keepRunning) {
            for (int j = 0; j < a1.length; j++) {
                short s = a1[j];
                if (s != (short) 0xffff && s != (short) 0x0000) {
                    System.out.println("Error: s = " + s);
                    throw new RuntimeException("wrong result");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14910().run();
    }
}
