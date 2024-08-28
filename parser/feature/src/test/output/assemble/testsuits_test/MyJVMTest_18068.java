import java.util.*;

public class MyJVMTest_18068 {

    static Enum e1 = null;

    static Enum e2 = null;

    Enum heterogeneousOf5(Enum e1, Enum e2) {
        try {
            EnumSet.of(e1, e1, e1, e1, e2);
        } catch (ClassCastException e) {
            return;
        }
        throw new RuntimeException("heterogeneous of (5 args) succeeded");
        return e1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18068().heterogeneousOf5(e1, e2);
    }
}
