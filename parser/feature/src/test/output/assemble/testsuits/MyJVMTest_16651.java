public class MyJVMTest_16651 {

    static int waitedNB = 5;

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
        new MyJVMTest_16651().count();
    }
}
