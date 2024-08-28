import javax.management.*;

public class MyJVMTest_6018 {

    static String mbiParam1 = ",DK1^O)@J3";

    static String mbiParam2 = "V8\"yX?2.|d";

    static MBeanAttributeInfo[] mbiParam3 = { null, null, null, null, null, null, null, null, null, null };

    static MBeanConstructorInfo[] mbiParam4 = { null, null, null, null, null, null, null, null, null, null };

    static MBeanOperationInfo[] mbiParam5 = { null, null, null, null, null, null, null, null, null, null };

    static MBeanNotificationInfo[] mbiParam6 = { null, null, null, null, null, null, null, null, null, null };

    static Descriptor mbiParam7 = null;

    static MBeanInfo mbi = new MBeanInfo(mbiParam1, mbiParam2, mbiParam3, mbiParam4, mbiParam5, mbiParam6, mbiParam7);

    static boolean expected = true;

    static String what = "V9#eo#Kum!";

    static String failure = "=*k?^.eC9.";

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
        System.out.println(new MyJVMTest_6018().checkMXBean(mbi, expected, what));
    }
}
