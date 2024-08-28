import java.lang.management.*;
import javax.management.*;

public class MyJVMTest_15149 {

    static int x = 5;

    String notOverloaded(int x) {
        return "notOverloaded";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15149().notOverloaded(x));
    }
}
