public class MyJVMTest_17146 {

    void flush() {
        System.out.flush();
    }

    void close() {
        flush();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17146().close();
    }
}
