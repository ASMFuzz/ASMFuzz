import java.security.PrivilegedAction;

public class MyJVMTest_3875 {

    Object run() {
        System.getProperty("test.property1");
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3875().run());
    }
}
