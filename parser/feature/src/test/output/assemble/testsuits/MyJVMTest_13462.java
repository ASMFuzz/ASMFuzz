import java.util.*;

public class MyJVMTest_13462 {

    static Class<T> enumClass = null;

    static T e0 = null;

    static T e1 = null;

    <T extends Enum<T>> T test(Class<T> enumClass, T e0, T e1) {
        try {
            EnumSet<T> range = EnumSet.range(e0, e1);
        } catch (IllegalArgumentException e) {
            return;
        }
        throw new RuntimeException(enumClass.toString());
        return e1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13462().test(enumClass, e0, e1);
    }
}
