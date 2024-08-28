import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_3148 {

    static boolean done = false;

    static MBeanServerConnection conn = null;

    boolean isDone() {
        synchronized (this) {
            return done;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3148().isDone());
    }
}
