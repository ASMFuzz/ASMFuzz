public class MyJVMTest_7651 {

    void randomDelay() {
        int runs = (int) Math.random() * 1000000;
        int c = 0;
        for (int i = 0; i < runs; ++i) {
            c = c + i;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7651().randomDelay();
    }
}
