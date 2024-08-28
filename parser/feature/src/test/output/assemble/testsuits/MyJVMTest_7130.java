public class MyJVMTest_7130 {

    static int waitedNB = 3;

    static int counted = 0;

    void count() {
        synchronized (this) {
            counted++;
            if (counted == waitedNB) {
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7130().count();
    }
}
