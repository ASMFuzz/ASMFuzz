public class MyJVMTest_16718 {

    static int callCount = 0;

    void callTracker() {
        ++callCount;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16718().callTracker();
    }
}
