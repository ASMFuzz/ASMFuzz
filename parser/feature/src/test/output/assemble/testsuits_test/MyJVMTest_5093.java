import java.util.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;

public class MyJVMTest_5093 {

    void fail() {
        throw new AssertionError();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5093().fail();
    }
}
