import java.security.*;

public class MyJVMTest_14512 {

    Object run() {
        return System.getProperty("user.name");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14512().run());
    }
}
