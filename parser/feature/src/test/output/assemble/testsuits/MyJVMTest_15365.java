public class MyJVMTest_15365 {

    void run() throws InterruptedException {
        String name = "";
        for (int i = 0; i < 10000; i++) {
            Thread myThread = new Thread(name) {

                public void run() {
                }
            };
            myThread.start();
            myThread.join();
            name = name + "\u30b9";
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15365().run();
    }
}
