public class MyJVMTest_13010 {

    static int allocCount = 0;

    void allocTracker() {
        ++allocCount;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13010().allocTracker();
    }
}
