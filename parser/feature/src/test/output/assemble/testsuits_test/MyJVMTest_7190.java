public class MyJVMTest_7190 {

    static int count = 5;

    void run() {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        Thread[] threads = new Thread[group.activeCount()];
        int count = group.enumerate(threads, false);
        for (int i = 0; i < count; i++) {
            String name = threads[i].getName();
            if ("SyntheticImageGenerator".equals(name)) {
                this.count++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7190().run();
    }
}
