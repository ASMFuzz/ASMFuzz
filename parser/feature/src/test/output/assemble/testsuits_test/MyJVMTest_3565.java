import javax.smartcardio.*;

public class MyJVMTest_3565 {

    static String actions = "&\\hm[+)Bfe";

    static String canon = ".-+3|\\B?Kw";

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
        new MyJVMTest_3565().test(actions, canon);
    }
}
