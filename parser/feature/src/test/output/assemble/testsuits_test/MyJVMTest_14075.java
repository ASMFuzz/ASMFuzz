import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_14075 {

    static int count = -1601785828;

    static Counter counter = null;

    int count() {
        count++;
        notifyAll();
        return count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14075().count());
    }
}
