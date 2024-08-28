import java.util.*;

public class MyJVMTest_10054 {

    static Enum e1 = null;

    static Enum e2 = null;

    Enum heterogeneousOf3(Enum e1, Enum e2) {
        try {
            EnumSet.of(e1, e1, e2);
        } catch (ClassCastException e) {
            return;
        }
        throw new RuntimeException("heterogeneous of (3 args) succeeded");
        return e1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10054().heterogeneousOf3(e1, e2);
    }
}
