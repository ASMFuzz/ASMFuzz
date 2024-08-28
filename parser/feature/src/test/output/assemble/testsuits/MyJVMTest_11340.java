import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_11340 {

    void ig() {
        throw new RuntimeException();
    }

    void ig4() {
        ig();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11340().ig4();
    }
}
