import java.util.*;

public class MyJVMTest_3671 {

    static Enum e1 = null;

    static Enum e2 = null;

    Enum heterogeneousOfVar(Enum e1, Enum e2) {
        try {
            EnumSet.of(e1, e1, e1, e1, e1, e2);
        } catch (ClassCastException e) {
            return;
        }
        throw new RuntimeException("heterogeneous of (Var args) succeeded");
        return e1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3671().heterogeneousOfVar(e1, e2);
    }
}
