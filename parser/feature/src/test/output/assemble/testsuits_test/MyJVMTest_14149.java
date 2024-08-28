public class MyJVMTest_14149 {

    static java.util.Random rnd = new java.util.Random();

    static int[] values = new int[256];

    void init() {
        for (int i = 0; i < values.length; ++i) {
            values[i] = rnd.nextInt();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14149().init();
    }
}
