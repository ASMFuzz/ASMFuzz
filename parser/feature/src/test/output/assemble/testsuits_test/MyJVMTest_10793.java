import java.lang.reflect.*;
import java.lang.annotation.*;
import static java.lang.reflect.Modifier.*;

public class MyJVMTest_10793 {

    void baz() {
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10793().baz();
    }
}
