import java.lang.reflect.*;
import java.lang.annotation.*;
import static java.lang.reflect.Modifier.*;

public class MyJVMTest_2348 {

    void foo() {
        ;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2348().foo();
    }
}
