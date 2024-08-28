import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.security.Permission;
import java.util.Arrays;

public class MyJVMTest_6800 {

    Object[][] getContents() {
        return new Object[][] { { "dummy", "foo" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_6800().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_6800().getContents()[1]));
    }
}
