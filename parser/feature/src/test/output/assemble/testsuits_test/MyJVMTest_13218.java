import java.security.PrivilegedAction;

public class MyJVMTest_13218 {

    Object run() {
        System.getProperty("test.property1");
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13218().run());
    }
}
