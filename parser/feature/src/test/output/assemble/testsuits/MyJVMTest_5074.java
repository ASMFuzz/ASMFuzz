import java.util.*;
import java.util.function.*;

public class MyJVMTest_5074 {

    int testIsNull() {
        int errors = 0;
        errors += Objects.isNull(null) ? 0 : 1;
        errors += Objects.isNull(Objects.class) ? 1 : 0;
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5074().testIsNull());
    }
}
