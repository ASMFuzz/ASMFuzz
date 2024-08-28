import javax.smartcardio.*;

public class MyJVMTest_12899 {

    static String actions = "VN(vcCxd`\"";

    static String canon = "V+u/=5e9[!";

    String test(String actions, String canon) throws Exception {
        CardPermission p = new CardPermission("*", actions);
        System.out.println(p);
        String a = p.getActions();
        if (canon != null && canon.equals(a) == false) {
            throw new Exception("Canonical actions mismatch: " + canon + " != " + a);
        }
        return canon;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12899().test(actions, canon);
    }
}
