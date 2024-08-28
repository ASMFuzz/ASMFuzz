import java.util.*;

public class MyJVMTest_14817 {

    void m() {
        Vector v = new Vector();
        Iterator iter = v.iterator();
        while (iter.hasNext()) {
            Object o = iter.next();
            Object o2 = o;
        }
        for (Object o : v) {
            Object o2 = o;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14817().m();
    }
}
