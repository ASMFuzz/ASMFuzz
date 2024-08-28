import java.util.*;
import java.util.function.*;

public class MyJVMTest_1714 {

    int testToString() {
        int errors = 0;
        errors += ("null".equals(Objects.toString(null))) ? 0 : 1;
        String s = "Some string";
        errors += (s.equals(Objects.toString(s))) ? 0 : 1;
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1714().testToString());
    }
}
