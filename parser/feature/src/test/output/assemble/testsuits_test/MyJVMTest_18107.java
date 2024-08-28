public class MyJVMTest_18107 {

    void run() {
        System.runFinalization();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18107().run();
    }
}
