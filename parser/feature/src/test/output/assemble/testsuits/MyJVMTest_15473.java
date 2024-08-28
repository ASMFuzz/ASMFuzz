import javax.management.*;

public class MyJVMTest_15473 {

    static String mbiParam1 = "`Kb,E$kpwA";

    static String mbiParam2 = "v0NXT/YmXx";

    static MBeanAttributeInfo[] mbiParam3 = { null, null, null, null, null, null, null, null, null, null };

    static MBeanConstructorInfo[] mbiParam4 = { null, null, null, null, null, null, null, null, null, null };

    static MBeanOperationInfo[] mbiParam5 = { null, null, null, null, null, null, null, null, null, null };

    static MBeanNotificationInfo[] mbiParam6 = { null, null, null, null, null, null, null, null, null, null };

    static Descriptor mbiParam7 = null;

    static MBeanInfo mbi = new MBeanInfo(mbiParam1, mbiParam2, mbiParam3, mbiParam4, mbiParam5, mbiParam6, mbiParam7);

    static boolean expected = false;

    static String what = "/gk7U\\{1k?";

    static String failure = "Ch!m3le^8s";

    boolean checkMXBean(MBeanInfo mbi, boolean expected, String what) {
        Descriptor d = mbi.getDescriptor();
        String mxbean = (String) d.getFieldValue("mxbean");
        boolean is = (mxbean != null && mxbean.equals("true"));
        if (is == expected)
            return true;
        else {
            failure = "MBean should " + (expected ? "" : "not ") + "have mxbean=true: " + d;
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15473().checkMXBean(mbi, expected, what));
    }
}
