import java.lang.reflect.Field;

public class MyJVMTest_1097 {

    static String msg = "ia,F~f_~y#";

    static Method setDomainLengthM = null;

    static Field compressedStorageFld = null;

    static int DOMAIN_PATTERN = 2;

    static int PROPLIST_PATTERN = 0;

    static int PROPVAL_PATTERN = 6;

    static Method setDomainPattern = null;

    static Method setPropertyListPattern = null;

    static Method setPropertyValuePattern = null;

    String fail(String msg) {
        throw new Error(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1097().fail(msg);
    }
}
