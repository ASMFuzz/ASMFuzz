public class MyJVMTest_14330 {

    static byte[] dummy = {85,62,-82,99,-45,-92,31,-92,-10,-121};

    static int sleepFreq = 40;

    static int sleepTime = 1000;

    static double size = 0.75;

    static int iterations = 50;

    int allocate(int size, int sleepTime, int sleepFreq) throws InterruptedException {
        System.out.println("Will allocate objects of size: " + size + " bytes and sleep for " + sleepTime + " ms after every " + sleepFreq + "th allocation.");
        int count = 0;
        while (count < iterations) {
            for (int i = 0; i < sleepFreq; i++) {
                dummy = new byte[size - 16];
            }
            Thread.sleep(sleepTime);
            count++;
        }
        return sleepTime;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14330().allocate(size, sleepTime, sleepFreq);
    }
}
