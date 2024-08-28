import java.lang.invoke.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_13694 {

    String foo() {
        return "foo!";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13694().foo());
    }
}
