import javax.management.*;

public class MyJVMTest_16768 {

    static MBeanServer mbs = null;

    static ObjectName on = null;

    ObjectName preRegister(MBeanServer mbs, ObjectName on) {
        this.mbs = mbs;
        this.on = on;
        return on;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16768().preRegister(mbs, on));
    }
}
