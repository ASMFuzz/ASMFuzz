import java.lang.management.*;
import javax.management.*;

public class MyJVMTest_4200 {

    static String x = "2(o;!X?H\">";

    String overloaded(String x) {
        return "overloaded(String)";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4200().overloaded(x));
    }
}
