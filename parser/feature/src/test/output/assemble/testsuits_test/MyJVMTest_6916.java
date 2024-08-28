public class MyJVMTest_6916 {

    void run() {
        throw new Error("method is overridden");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6916().run();
    }
}
