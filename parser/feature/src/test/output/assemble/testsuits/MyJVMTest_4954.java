public class MyJVMTest_4954 {

    void run() {
        int i = 0;
        while (i < 10) {
            try {
                System.out.println("Sleep inside Hook ...." + i);
                Thread.sleep(1000);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4954().run();
    }
}
