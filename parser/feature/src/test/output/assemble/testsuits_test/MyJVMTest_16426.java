public class MyJVMTest_16426 {

    void run() {
        throw new Error("method is overridden");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16426().run();
    }
}
