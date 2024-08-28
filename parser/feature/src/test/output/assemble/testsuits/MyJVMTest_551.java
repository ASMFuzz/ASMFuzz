import java.util.*;

public class MyJVMTest_551 {

    static Enum e1 = null;

    static Enum e2 = null;

    Enum heterogeneousOf4(Enum e1, Enum e2) {
        try {
            EnumSet.of(e1, e1, e1, e2);
        } catch (ClassCastException e) {
            return;
        }
        throw new RuntimeException("heterogeneous of (4 args) succeeded");
        return e1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_551().heterogeneousOf4(e1, e2);
    }
}
