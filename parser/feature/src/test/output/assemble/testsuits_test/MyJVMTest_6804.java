public class MyJVMTest_6804 {

    void run() {
        throw new Error();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6804().run();
    }
}
