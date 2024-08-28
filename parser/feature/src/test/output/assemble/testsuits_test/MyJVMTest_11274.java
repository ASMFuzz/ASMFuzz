import java.lang.reflect.*;

public class MyJVMTest_11274 {

    static Method m = null;

    int check(Method m) throws Exception {
        int mask = Modifier.ABSTRACT | Modifier.STRICT;
        if ((m.getModifiers() & mask) == mask)
            throw new Error();
        return mask;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11274().check(m);
    }
}
