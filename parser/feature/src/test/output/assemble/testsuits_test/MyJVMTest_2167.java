import java.security.PrivilegedExceptionAction;

public class MyJVMTest_2167 {

    Object run() throws Exception {
        System.getProperty("test.property2");
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2167().run());
    }
}
