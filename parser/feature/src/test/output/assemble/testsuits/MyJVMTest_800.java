import java.util.*;
import java.util.function.*;

public class MyJVMTest_800 {

    int testToString2() {
        int errors = 0;
        String s = "not the default";
        errors += (s.equals(Objects.toString(null, s))) ? 0 : 1;
        errors += (s.equals(Objects.toString(s, "another string"))) ? 0 : 1;
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_800().testToString2());
    }
}
