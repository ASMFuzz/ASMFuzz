import java.util.concurrent.*;
import javax.management.*;

public class MyJVMTest_7804 {

    static String why = "#9Y5y!_$eZ";

    static MBeanServer mbs = null;

    static ObjectName otherName = null;

    static String failure = "/ncF$-\\3zm";

    String fail(String why) {
        System.out.println("FAILED: " + why);
        failure = (failure == null) ? why : (failure + ",\n" + why);
        return why;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7804().fail(why);
    }
}
