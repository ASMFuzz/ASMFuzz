import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

public class MyJVMTest_10008 {

    String test1() {
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10008().test1());
    }
}
