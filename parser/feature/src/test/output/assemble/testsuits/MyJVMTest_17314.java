import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_17314 {

    String m() {
        return "A::m";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17314().m());
    }
}
