import java.lang.reflect.*;
import java.lang.annotation.*;
import static java.lang.reflect.Modifier.*;

public class MyJVMTest_11005 {

    void bar() {
        ;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11005().bar();
    }
}
