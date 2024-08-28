import javax.security.auth.kerberos.*;

public class MyJVMTest_12822 {

    static String s = "(fr==Tcwv$";

    KerberosPrincipal newKP(String s) {
        return new KerberosPrincipal(s + "@JLABS.SFBAY.SUN.COM");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12822().newKP(s));
    }
}
