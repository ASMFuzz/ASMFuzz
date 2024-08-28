import java.security.*;
import javax.security.auth.login.*;
import com.sun.security.auth.login.*;
import java.util.Arrays;

public class MyJVMTest_1654 {

    static String name = "\\_8Xg=.dUH";

    static Configuration c = null;

    AppConfigurationEntry[] engineGetAppConfigurationEntry(String name) {
        return c.getAppConfigurationEntry(name);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1654().engineGetAppConfigurationEntry(name)));
    }
}
