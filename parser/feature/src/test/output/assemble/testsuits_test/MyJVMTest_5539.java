public class MyJVMTest_5539 {

    static int seconds = 3;

    static int sleepTime = 300000;

    int setTimeoutTo(int seconds) {
        sleepTime = seconds * 1000;
        return seconds;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5539().setTimeoutTo(seconds);
    }
}
