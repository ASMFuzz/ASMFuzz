import java.lang.reflect.*;
import java.lang.annotation.*;
import static java.lang.reflect.Modifier.*;

public class MyJVMTest_1573 {

    void baz() {
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1573().baz();
    }
}
