import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_4299 {

    String m() {
        return "PB_PA::m";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4299().m());
    }
}
