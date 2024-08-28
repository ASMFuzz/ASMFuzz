import javax.management.*;
import java.util.concurrent.*;

public class MyJVMTest_1897 {

    static String type = "~wE2GSEkl6";

    static long next = 0;

    long next() {
        return next++;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1897().next());
    }
}
