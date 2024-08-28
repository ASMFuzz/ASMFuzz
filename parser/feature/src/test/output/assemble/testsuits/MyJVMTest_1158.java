import javax.management.*;

public class MyJVMTest_1158 {

    static MBeanServer mbs = null;

    static ObjectName n = null;

    static int count = 7;

    ObjectName preRegister(MBeanServer mbs, ObjectName n) {
        count++;
        return n;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1158().preRegister(mbs, n));
    }
}
