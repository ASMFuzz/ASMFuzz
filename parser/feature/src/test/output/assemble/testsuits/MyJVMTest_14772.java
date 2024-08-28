import java.security.Principal;

public class MyJVMTest_14772 {

    String getName() {
        return "TestPrincipal";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14772().getName());
    }
}
