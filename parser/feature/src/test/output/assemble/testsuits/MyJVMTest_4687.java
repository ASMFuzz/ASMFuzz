import java.util.concurrent.*;
import javax.management.*;

public class MyJVMTest_4687 {

    static String onParam1 = "O)R$q}D([d";

    static ObjectName on = new ObjectName(onParam1);

    static MBeanServer mbs = null;

    static ObjectName otherName = null;

    static ObjectName objectName = null;

    static Semaphore semaphore = null;

    ObjectName preRegister(MBeanServer mbs, ObjectName on) {
        this.objectName = on;
        return on;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4687().preRegister(mbs, on));
    }
}
