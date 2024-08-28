public class MyJVMTest_8517 {

    void run() {
        System.runFinalization();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8517().run();
    }
}
