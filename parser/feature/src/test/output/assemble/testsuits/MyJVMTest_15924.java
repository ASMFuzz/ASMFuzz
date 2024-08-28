import java.util.*;
import java.util.function.*;

public class MyJVMTest_15924 {

    int testNonNull() {
        int errors = 0;
        errors += Objects.nonNull(null) ? 1 : 0;
        errors += Objects.nonNull(Objects.class) ? 0 : 1;
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15924().testNonNull());
    }
}
