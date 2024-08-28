import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_14597 {

    void ig() {
        throw new RuntimeException();
    }

    void ig3() {
        ig();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14597().ig3();
    }
}
