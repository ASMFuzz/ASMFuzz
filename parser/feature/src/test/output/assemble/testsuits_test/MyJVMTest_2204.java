import java.lang.ref.Reference;

public class MyJVMTest_2204 {

    static Runnable proc = () -> {
    };

    static Reference r = null;

    Thread fork(Runnable proc) throws InterruptedException {
        Thread t = new Thread(proc);
        t.start();
        t.join();
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2204().fork(proc);
    }
}
