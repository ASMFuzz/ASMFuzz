import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_919 {

    void ig() {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_919().ig();
    }
}
