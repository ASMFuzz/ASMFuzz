import javax.naming.ldap.*;

public class MyJVMTest_12486 {

    static int n = 0;

    boolean isPositive(int n) {
        return (n >= 0) ? true : false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12486().isPositive(n));
    }
}
