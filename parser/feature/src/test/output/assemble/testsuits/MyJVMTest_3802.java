import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_3802 {

    String m() {
        return "B_PA::m";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3802().m());
    }
}
