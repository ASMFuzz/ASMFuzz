import java.lang.reflect.*;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

public class MyJVMTest_2625 {

    static int errors = 0;

    static int thing = 9;

    static int thang = 992393777;

    void checkForErrors() {
        if (errors > 0)
            throw new RuntimeException("Failed " + errors + " tests");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2625().checkForErrors();
    }
}
