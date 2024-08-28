public class MyJVMTest_7600 {

    void flush() {
        System.out.flush();
    }

    void close() {
        flush();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7600().close();
    }
}
