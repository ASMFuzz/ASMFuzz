public class MyJVMTest_2849 {

    void run() throws InterruptedException {
        for (int i = 0; i <= 255; i++) {
            Thread myThread = new Thread("" + (char) i) {

                public void run() {
                }
            };
            myThread.start();
            myThread.join();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2849().run();
    }
}
