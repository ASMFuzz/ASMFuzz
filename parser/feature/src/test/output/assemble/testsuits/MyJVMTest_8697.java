public class MyJVMTest_8697 {

    static int seconds = -919425858;

    static int sleepTime = 300000;

    int setTimeoutTo(int seconds) {
        sleepTime = seconds * 1000;
        return seconds;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8697().setTimeoutTo(seconds);
    }
}
