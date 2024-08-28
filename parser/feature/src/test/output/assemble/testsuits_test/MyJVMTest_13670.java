import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_13670 {

    String m() {
        return "PB_PA::m";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13670().m());
    }
}
