import java.lang.annotation.*;
import static test.TestGetElementReferenceData.Sub.*;

public class MyJVMTest_1953 {

    static Runnable r = () -> {
    };

    Runnable target(Runnable r) {
        r.run();
        return r;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1953().target(r);
    }
}
