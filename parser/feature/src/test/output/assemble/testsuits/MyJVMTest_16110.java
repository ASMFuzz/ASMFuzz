import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_16110 {

    static long seq = 0;

    long seq() {
        return ++seq;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16110().seq());
    }
}
