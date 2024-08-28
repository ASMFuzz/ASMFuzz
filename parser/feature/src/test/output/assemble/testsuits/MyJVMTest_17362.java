import java.util.concurrent.*;
import javax.management.*;

public class MyJVMTest_17362 {

    static String why = "qk. m'QCK4";

    static MBeanServer mbs = null;

    static ObjectName otherName = null;

    static String failure = "5\\SS2Wa89_";

    String fail(String why) {
        System.out.println("FAILED: " + why);
        failure = (failure == null) ? why : (failure + ",\n" + why);
        return why;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17362().fail(why);
    }
}
