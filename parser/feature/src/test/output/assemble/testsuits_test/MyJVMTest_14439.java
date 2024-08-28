import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_14439 {

    static int count = 990523362;

    int count() {
        count++;
        notifyAll();
        return count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14439().count());
    }
}
