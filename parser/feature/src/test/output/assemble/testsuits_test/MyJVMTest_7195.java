public class MyJVMTest_7195 {

    static int callCount = 0;

    void callTracker() {
        ++callCount;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7195().callTracker();
    }
}
