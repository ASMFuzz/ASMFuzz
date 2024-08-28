import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_929 {

    static MethodHandles.Lookup lookup = MethodHandles.lookup();

    static C iv = null;

    MethodHandle putFieldMH() {
        try {
            return lookup.findSetter(C.class, "iv", C.class);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_929().putFieldMH());
    }
}
