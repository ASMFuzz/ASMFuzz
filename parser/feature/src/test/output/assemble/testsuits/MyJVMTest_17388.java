import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_17388 {

    String m() {
        return "PC_PB_A";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17388().m());
    }
}
