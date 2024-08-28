import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_10761 {

    static int f2 = 0;

    void m2() {
        this.f2 = -2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10761().m2();
    }
}
