import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_17051 {

    String m() {
        return "B_A::m";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17051().m());
    }
}
