import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_5029 {

    static int count = 6;

    int count() {
        count++;
        notifyAll();
        return count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5029().count());
    }
}
