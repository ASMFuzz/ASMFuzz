import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_12756 {

    static MethodHandles.Lookup lookup = MethodHandles.lookup();

    static C sv = null;

    static C iv = null;

    MethodHandle getStaticMH() {
        try {
            return lookup.findStaticGetter(C.class, "sv", C.class);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12756().getStaticMH());
    }
}
