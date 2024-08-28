import java.lang.management.*;
import java.util.*;

public class MyJVMTest_6613 {

    static String minfoParam1 = "(ly-Ih&FrG";

    static long minfoParam2Param1 = 9223372036854775807L;

    static long minfoParam2Param2 = -9223372036854775808L;

    static long minfoParam2Param3 = 0;

    static long minfoParam2Param4 = -9223372036854775808L;

    static MemoryUsage minfoParam2 = new MemoryUsage(minfoParam2Param1, minfoParam2Param2, minfoParam2Param3, minfoParam2Param4);

    static long minfoParam3 = 0;

    static MemoryNotificationInfo minfo = new MemoryNotificationInfo(minfoParam1, minfoParam2, minfoParam3);

    static String type = "Y=2x|;*+(J";

    static String INDENT = "    ";

    MemoryNotificationInfo printMemoryNotificationInfo(MemoryNotificationInfo minfo, String type) {
        System.out.print("Notification for " + minfo.getPoolName());
        System.out.print(" [type = " + type);
        System.out.println(" count = " + minfo.getCount() + "]");
        System.out.println(INDENT + "usage = " + minfo.getUsage());
        return minfo;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6613().printMemoryNotificationInfo(minfo, type);
    }
}
