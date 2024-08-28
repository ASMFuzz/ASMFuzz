public class MyJVMTest_16730 {

    static boolean clear = false;

    void clear() {
        clear = true;
        notify();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16730().clear();
    }
}
