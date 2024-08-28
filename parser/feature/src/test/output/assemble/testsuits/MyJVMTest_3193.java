import java.util.concurrent.atomic.AtomicBoolean;

public class MyJVMTest_3193 {

    static AtomicBoolean suspend = new AtomicBoolean(false);

    static AtomicBoolean run = new AtomicBoolean(true);

    static int index = 0;

    void doInThisThread() {
        System.out.println("... Inside doThisThread..");
        while (hs204t001R.run.get()) {
            index += 10;
            if (index == 1500) {
                hs204t001R.suspend.set(true);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3193().doInThisThread();
    }
}
