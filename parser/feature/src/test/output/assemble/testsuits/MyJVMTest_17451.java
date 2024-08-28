import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_17451 {

    String m() {
        return "C_PB_A::m";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17451().m());
    }
}
