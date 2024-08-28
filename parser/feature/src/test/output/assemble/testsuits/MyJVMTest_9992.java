import java.util.*;

public class MyJVMTest_9992 {

    static Thread tdThread = null;

    void run() {
        tdThread = Thread.currentThread();
        throw new ThreadDeath();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9992().run();
    }
}
