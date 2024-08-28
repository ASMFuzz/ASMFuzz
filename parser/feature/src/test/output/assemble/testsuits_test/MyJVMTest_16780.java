import java.util.*;
import java.lang.reflect.*;

public class MyJVMTest_16780 {

    static List<Type> typeList = new ArrayList<Type>();

    boolean testReflexes(List<Type> typeList) {
        for (Type t : typeList) {
            if (!t.equals(t)) {
                System.err.printf("Bad reflexes for%s %s%n", t, t.getClass());
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16780().testReflexes(typeList));
    }
}
