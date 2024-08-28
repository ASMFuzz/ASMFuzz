import java.nio.channels.*;

public class MyJVMTest_608 {

    static boolean done = true;

    void run() {
        while (!done) ;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_608().run();
    }
}
