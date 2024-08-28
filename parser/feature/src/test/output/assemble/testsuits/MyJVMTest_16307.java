public class MyJVMTest_16307 {

    void run() {
        throw new Error();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16307().run();
    }
}
