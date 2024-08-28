import static javax.lang.model.type.TypeKind.*;
import javax.lang.model.util.*;
import java.util.*;
import javax.lang.model.type.TypeKind;

public class MyJVMTest_13413 {

    int testIsPrimitive() {
        int failures = 0;
        Set<TypeKind> primitives = EnumSet.of(BOOLEAN, BYTE, CHAR, DOUBLE, FLOAT, INT, LONG, SHORT);
        for (TypeKind tk : TypeKind.values()) {
            boolean primitiveness;
            if ((primitiveness = tk.isPrimitive()) != primitives.contains(tk)) {
                failures++;
                System.err.println("Unexpected isPrimitive value " + primitiveness + "for " + tk);
            }
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13413().testIsPrimitive());
    }
}
