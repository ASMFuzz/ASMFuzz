public class MyJVMTest_2614 {

    static Thread t1 = null, t2 = null;

    void randomDelay() {
        int runs = (int) Math.random() * 1000000;
        int c = 0;
        for (int i = 0; i < runs; ++i) {
            c = c + i;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2614().randomDelay();
    }
}
