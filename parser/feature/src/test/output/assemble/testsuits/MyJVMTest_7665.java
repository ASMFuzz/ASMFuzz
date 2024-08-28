import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_7665 {

    static MethodHandles.Lookup lookup = MethodHandles.lookup();

    static C sv = null;

    static C iv = null;

    MethodHandle putStaticMH() {
        try {
            return lookup.findStaticSetter(C.class, "sv", C.class);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7665().putStaticMH());
    }
}
