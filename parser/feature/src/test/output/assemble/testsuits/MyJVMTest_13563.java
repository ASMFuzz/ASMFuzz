import java.lang.management.*;
import javax.management.*;

public class MyJVMTest_13563 {

    static String x = "L\"j}?d{93V";

    String overloaded(String x) {
        return "overloaded(String)";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13563().overloaded(x));
    }
}
