import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_2094 {

    void ig() {
        throw new RuntimeException();
    }

    void ig4() {
        ig();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2094().ig4();
    }
}
