import java.lang.reflect.Field;

public class MyJVMTest_10292 {

    static String msg = ":|PT.&+#1x";

    static Method setDomainLengthM = null;

    static Field compressedStorageFld = null;

    static int DOMAIN_PATTERN = 0;

    static int PROPLIST_PATTERN = 2;

    static int PROPVAL_PATTERN = 0;

    static Method setDomainPattern = null;

    static Method setPropertyListPattern = null;

    static Method setPropertyValuePattern = null;

    String fail(String msg) {
        throw new Error(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10292().fail(msg);
    }
}
