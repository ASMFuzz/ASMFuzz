import javax.naming.ldap.*;

public class MyJVMTest_3170 {

    static int n = -1998998467;

    boolean isPositive(int n) {
        return (n >= 0) ? true : false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3170().isPositive(n));
    }
}
