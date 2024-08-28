import javax.management.*;
import java.util.*;

public class MyJVMTest_16390 {

    static Set instances = new HashSet();

    Set printInstances(Set instances) {
        for (Iterator it1 = instances.iterator(); it1.hasNext(); ) {
            final ObjectInstance oi = (ObjectInstance) it1.next();
            final ObjectName on = oi.getObjectName();
            final String cn = oi.getClassName();
            System.err.println(String.valueOf(on) + ": class is " + cn);
        }
        return instances;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16390().printInstances(instances);
    }
}
