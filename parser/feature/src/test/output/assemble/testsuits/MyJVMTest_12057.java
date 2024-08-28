import java.util.*;
import java.util.function.*;

public class MyJVMTest_12057 {

    int testHashCode() {
        int errors = 0;
        errors += (Objects.hashCode(null) == 0) ? 0 : 1;
        String s = "42";
        errors += (Objects.hashCode(s) == s.hashCode()) ? 0 : 1;
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12057().testHashCode());
    }
}
