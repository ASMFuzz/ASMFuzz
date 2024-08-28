import java.lang.management.*;
import javax.management.*;

public class MyJVMTest_3695 {

    static String[] notifParam1 = { "Yluf58[SPA", "<&&p^Mx6o>", "#cC/64 RQ;", "O~dd)CU02z", "|x,KjVtsH<", "}@uU{9Yf?i", "q(z=:{-CJ-", "O~/l!PfIBZ", "4%[E~OhZH<", ":jzx?\\Y44a" };

    static String notifParam2 = "Tdg#U|PZ/.";

    static String notifParam3 = "+,xhJ$P]g{";

    static Descriptor notifParam4 = null;

    static MBeanNotificationInfo notif = new MBeanNotificationInfo(notifParam1, notifParam2, notifParam3, notifParam4);

    static int count = 0;

    String[] printNotifType(MBeanNotificationInfo notif) {
        String[] types = notif.getNotifTypes();
        for (int i = 0; i < types.length; i++) {
            System.out.println(types[i]);
            count++;
        }
        return types;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3695().printNotifType(notif);
    }
}
