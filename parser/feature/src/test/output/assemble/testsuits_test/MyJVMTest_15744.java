import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_15744 {

    static int count = 6;

    static Counter counter = null;

    static long seq = 0;

    long seq() {
        return ++seq;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15744().seq());
    }
}
