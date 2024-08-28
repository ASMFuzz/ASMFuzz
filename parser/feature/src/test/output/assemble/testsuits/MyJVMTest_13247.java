public class MyJVMTest_13247 {

    static int closeCount = 0;

    void close() {
        closeCount++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13247().close();
    }
}
