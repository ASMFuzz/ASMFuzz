import javax.management.*;

public class MyJVMTest_10354 {

    static MBeanServer mbs = null;

    static String nParam1 = "Fn_20/$l90";

    static ObjectName n = new ObjectName(nParam1);

    static int count = 74707179;

    ObjectName preRegister(MBeanServer mbs, ObjectName n) {
        count++;
        return n;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10354().preRegister(mbs, n));
    }
}
