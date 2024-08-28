public class MyJVMTest_3673 {

    static int allocCount = 0;

    void allocTracker() {
        ++allocCount;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3673().allocTracker();
    }
}
