import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_7760 {

    String m() {
        return "A::m";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7760().m());
    }
}
