import java.lang.management.*;
import javax.management.*;

public class MyJVMTest_5709 {

    static int x = 0;

    String notOverloaded(int x) {
        return "notOverloaded";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5709().notOverloaded(x));
    }
}
