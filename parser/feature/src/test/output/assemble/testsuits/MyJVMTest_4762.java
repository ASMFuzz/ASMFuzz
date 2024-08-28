public class MyJVMTest_4762 {

    static long value = 0;

    static boolean got_backward_time = false;

    static boolean done = false;

    void run() {
        for (long l = 0; !done && l < 100000; l++) {
            final long start = System.nanoTime();
            if (value == 12345678) {
                System.out.println("Wow!");
            }
            final long end = System.nanoTime();
            final long time = end - start;
            value += time;
            if (time < 0) {
                System.out.println("Backwards: " + "start=" + start + " " + "end=" + end + " " + "time= " + time);
                got_backward_time = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4762().run();
    }
}
