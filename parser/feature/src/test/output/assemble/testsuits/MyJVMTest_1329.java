import java.lang.management.*;
import java.util.*;

public class MyJVMTest_1329 {

    static LockInfo[] locks = { null, null, null, null, null, null, null, null, null, null };

    static String INDENT = "   ";

    LockInfo[] printLockInfo(LockInfo[] locks) {
        System.out.println(INDENT + "Locked synchronizers: count = " + locks.length);
        for (LockInfo li : locks) {
            System.out.println(INDENT + "  - " + li);
        }
        return locks;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1329().printLockInfo(locks);
    }
}
