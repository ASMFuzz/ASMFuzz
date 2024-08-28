import java.nio.channels.*;

public class MyJVMTest_9775 {

    static boolean done = true;

    void run() {
        while (!done) ;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9775().run();
    }
}
