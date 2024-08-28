import java.lang.management.*;
import javax.management.*;

public class MyJVMTest_13032 {

    static String[] notifParam1 = { "jMKoaz^,'Q", "_52=oT1;]X", "K#eGZg,DMU", "PDpW=`h]s?", "MQV> |P~?^", "!>t J6\\.mP", "$N,qf#U.d^", "Zx?vho-vv8", "K&r(ru$$H\"", "p8{$2nzo$%" };

    static String notifParam2 = " A\\98Jb>xi";

    static String notifParam3 = "cA7eY,.D,2";

    static MBeanNotificationInfo notif = new MBeanNotificationInfo(notifParam1, notifParam2, notifParam3);

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
        new MyJVMTest_13032().printNotifType(notif);
    }
}
