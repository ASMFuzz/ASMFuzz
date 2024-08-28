public class MyJVMTest_9047 {

    static int counter = 0;

    void run() {
        ++counter;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9047().run();
    }
}
