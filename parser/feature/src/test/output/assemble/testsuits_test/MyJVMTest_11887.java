import java.util.*;

public class MyJVMTest_11887 {

    static Class<T> enumClass = null;

    static int expected = 0;

    <T extends Enum<T>> EnumSet<T> test(Class<T> enumClass, int expected) {
        EnumSet<T> set = EnumSet.allOf(enumClass);
        if (set.size() != expected)
            throw new RuntimeException(set.size() + " != " + expected);
        set.toString();
        return set;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11887().test(enumClass, expected);
    }
}
