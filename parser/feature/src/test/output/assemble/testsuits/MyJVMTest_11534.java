import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_11534 {

    String m() {
        return "PC_B_PA";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11534().m());
    }
}
