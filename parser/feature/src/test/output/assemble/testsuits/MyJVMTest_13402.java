import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_13402 {

    String m() {
        return "PA::m";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13402().m());
    }
}
