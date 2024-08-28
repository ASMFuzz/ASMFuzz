import javax.security.auth.kerberos.*;

public class MyJVMTest_3491 {

    static String s = "@A+y^>'w?!";

    KerberosPrincipal newKP(String s) {
        return new KerberosPrincipal(s + "@JLABS.SFBAY.SUN.COM");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3491().newKP(s));
    }
}
