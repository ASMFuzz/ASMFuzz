import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_6132 {

    void ig() {
        throw new RuntimeException();
    }

    void ig2() {
        ig();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6132().ig2();
    }
}
