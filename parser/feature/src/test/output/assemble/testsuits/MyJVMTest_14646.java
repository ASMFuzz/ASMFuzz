import java.util.*;

public class MyJVMTest_14646 {

    static Class<T> enumClass = null;

    <T extends Enum<T>> EnumSet<T> test(Class<T> enumClass) {
        EnumSet<T> set = EnumSet.allOf(enumClass);
        EnumSet<T> setComplement = EnumSet.complementOf(set);
        if (setComplement.size() != 0)
            throw new RuntimeException(setComplement.size() + " != 0");
        setComplement.toString();
        return setComplement;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14646().test(enumClass);
    }
}
