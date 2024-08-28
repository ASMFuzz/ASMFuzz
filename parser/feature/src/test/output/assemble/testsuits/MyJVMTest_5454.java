public class MyJVMTest_5454 {

    static int callCount = 0;

    static int allocCount = 0;

    void reset() {
        callCount = 0;
        allocCount = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5454().reset();
    }
}
