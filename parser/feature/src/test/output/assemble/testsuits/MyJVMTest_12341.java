import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_12341 {

    static int f2 = 0;

    void m1() {
        this.f2 = -1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12341().m1();
    }
}
