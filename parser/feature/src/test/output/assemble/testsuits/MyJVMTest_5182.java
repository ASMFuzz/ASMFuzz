public class MyJVMTest_5182 {

    void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5182().run();
    }
}
