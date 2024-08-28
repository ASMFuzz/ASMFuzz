import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_2725 {

    void ig() {
        throw new RuntimeException();
    }

    void ig1() {
        ig();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2725().ig1();
    }
}
