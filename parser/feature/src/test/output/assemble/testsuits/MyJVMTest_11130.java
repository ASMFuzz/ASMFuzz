import javax.management.*;
import java.util.concurrent.*;

public class MyJVMTest_11130 {

    static String type = "O$YhOm)!3^";

    static long next = 0;

    long next() {
        return next++;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11130().next());
    }
}
