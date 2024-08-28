import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_4507 {

    String m() {
        return "C_PB_PA::m";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4507().m());
    }
}
