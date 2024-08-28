import java.util.concurrent.atomic.AtomicBoolean;

public class MyJVMTest_3093 {

    void doInThisThread() {
        System.out.println("... Inside doThisThread..");
        while (hs204t001R.run.get()) {
            index += 10;
            if (index == 1500) {
                hs204t001R.suspend.set(true);
            }
        }
    }

    static AtomicBoolean suspend = new AtomicBoolean(false);

    static AtomicBoolean run = new AtomicBoolean(true);

    static int index = 0;

    void run() {
        System.out.println(" started running thread..");
        doInThisThread();
        System.out.println(" comming out ..");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3093().run();
    }
}
