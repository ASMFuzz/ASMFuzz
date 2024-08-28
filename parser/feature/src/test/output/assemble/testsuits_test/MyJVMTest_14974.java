public class MyJVMTest_14974 {

    static int seconds = 333811465;

    static int sleepTime = 300000;

    int setTimeoutTo(int seconds) {
        sleepTime = seconds * 1000;
        return seconds;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14974().setTimeoutTo(seconds);
    }
}
