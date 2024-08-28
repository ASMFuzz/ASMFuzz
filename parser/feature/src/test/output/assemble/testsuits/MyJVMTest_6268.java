import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_6268 {

    static int count = 7;

    static Counter counter = null;

    static long seq = 0;

    long seq() {
        return ++seq;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6268().seq());
    }
}
