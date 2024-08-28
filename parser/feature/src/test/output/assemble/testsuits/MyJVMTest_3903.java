public class MyJVMTest_3903 {

    static int closeCount = 0;

    void close() {
        closeCount++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3903().close();
    }
}
