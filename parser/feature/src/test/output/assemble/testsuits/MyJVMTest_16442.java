public class MyJVMTest_16442 {

    void run() {
        switch(42) {
            default:
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16442().run();
    }
}
