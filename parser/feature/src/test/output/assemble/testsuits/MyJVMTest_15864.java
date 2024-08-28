public class MyJVMTest_15864 {

    static boolean laxLineEndings = false;

    static boolean closed = false;

    void close() {
        closed = true;
        notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15864().close();
    }
}
