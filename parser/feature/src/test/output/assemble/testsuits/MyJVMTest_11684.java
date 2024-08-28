public class MyJVMTest_11684 {

    static int counter = 0;

    void run() {
        ++counter;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11684().run();
    }
}
