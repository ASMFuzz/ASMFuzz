import java.util.HashMap;
import javax.security.auth.login.AppConfigurationEntry;
import java.util.Arrays;

public class MyJVMTest_9663 {

    static String applicationName = "My)r_:_\\|S";

    static AppConfigurationEntry[] ptAE = new AppConfigurationEntry[2];

    static boolean optionOrder = false;

    AppConfigurationEntry[] getAppConfigurationEntry(String applicationName) {
        if (applicationName.equals("PT")) {
            return ptAE;
        } else {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_9663().getAppConfigurationEntry(applicationName)));
    }
}
