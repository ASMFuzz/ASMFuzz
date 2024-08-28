public class MyJVMTest_6383 {

    static boolean laxLineEndings = true;

    static boolean closed = false;

    void close() {
        closed = true;
        notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6383().close();
    }
}
