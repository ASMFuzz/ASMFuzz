import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

public class MyJVMTest_13256 {

    String test2() {
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13256().test2());
    }
}
