import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

public class MyJVMTest_10585 {

    String test3() {
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10585().test3());
    }
}
