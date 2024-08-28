import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_3035 {

    static int f2 = 8;

    void m1() {
        this.f2 = -1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3035().m1();
    }
}
