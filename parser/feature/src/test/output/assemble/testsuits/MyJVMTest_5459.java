public class MyJVMTest_5459 {

    static Thread[] threads = { null, null, null, null, null, null, null, null, null, null };

    static long payload1 = 6755027956921592556L;

    static long payload2 = 0;

    static long payload3 = 5945054653105778392L;

    static long payload4 = -9223372036854775808L;

    Thread[] joinThreads(Thread[] threads) throws Exception {
        for (int i = 0; i < threads.length; i++) {
            try {
                if (threads[i] != null) {
                    threads[i].join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw e;
            }
        }
        return threads;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5459().joinThreads(threads);
    }
}
