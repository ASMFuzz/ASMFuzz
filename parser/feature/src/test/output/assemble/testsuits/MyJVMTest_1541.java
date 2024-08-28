import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_1541 {

    static int f2 = -485312139;

    void m2() {
        this.f2 = -2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1541().m2();
    }
}
