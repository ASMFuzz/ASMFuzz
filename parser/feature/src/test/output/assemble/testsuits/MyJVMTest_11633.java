import java.lang.management.*;
import javax.management.*;

public class MyJVMTest_11633 {

    String overloaded() {
        return "overloaded()";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11633().overloaded());
    }
}
