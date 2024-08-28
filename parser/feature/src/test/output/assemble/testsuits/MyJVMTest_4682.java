import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_4682 {

    static int count = 1;

    static Counter counter = null;

    int count() {
        count++;
        notifyAll();
        return count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4682().count());
    }
}
