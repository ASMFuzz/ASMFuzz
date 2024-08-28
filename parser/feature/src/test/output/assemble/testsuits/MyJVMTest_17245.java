import javax.management.*;
import static java.lang.management.ManagementFactory.*;
import java.lang.management.*;

public class MyJVMTest_17245 {

    static MBeanServer server = ManagementFactory.getPlatformMBeanServer();

    static ObjectName runtime = null;

    static String OPTION = "-verbose:gc";

    void checkList() throws Exception {
        String[] args = (String[]) server.getAttribute(runtime, "InputArguments");
        if (args.length < 1) {
            throw new RuntimeException("TEST FAILED: " + " empty input arguments");
        }
        boolean found = false;
        for (String option : args) {
            if (option.equals(OPTION)) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new RuntimeException("TEST FAILED: " + "VM option " + OPTION + " not found");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17245().checkList();
    }
}
