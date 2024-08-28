public class MyJVMTest_7207 {

    static boolean clear = false;

    void clear() {
        clear = true;
        notify();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7207().clear();
    }
}
