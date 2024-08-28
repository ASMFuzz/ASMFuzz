import java.util.*;

public class MyJVMTest_8004 {

    static Enum e1 = null;

    static Enum e2 = null;

    Enum heterogeneousOf2(Enum e1, Enum e2) {
        try {
            EnumSet.of(e1, e2);
        } catch (ClassCastException e) {
            return;
        }
        throw new RuntimeException("heterogeneous of (2 args) succeeded");
        return e2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8004().heterogeneousOf2(e1, e2);
    }
}
