import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_9415 {

    static MethodHandles.Lookup lookup = MethodHandles.lookup();

    static C iv = null;

    MethodHandle getFieldMH() {
        try {
            return lookup.findGetter(C.class, "iv", C.class);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9415().getFieldMH());
    }
}
