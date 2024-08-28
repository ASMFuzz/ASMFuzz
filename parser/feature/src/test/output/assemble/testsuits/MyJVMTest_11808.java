import java.util.*;

public class MyJVMTest_11808 {

    static Class<T> enumClass = null;

    static T e0 = null;

    static T e1 = null;

    <T extends Enum<T>> T test(Class<T> enumClass, T e0, T e1) {
        EnumSet<T> range = EnumSet.range(e0, e1);
        if (range.size() != e1.ordinal() - e0.ordinal() + 1)
            throw new RuntimeException(range.size() + " != " + (e1.ordinal() - e0.ordinal() + 1));
        return e1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11808().test(enumClass, e0, e1);
    }
}
