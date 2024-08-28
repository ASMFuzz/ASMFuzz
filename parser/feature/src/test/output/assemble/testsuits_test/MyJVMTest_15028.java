public class MyJVMTest_15028 {

    static String a = "t!|'V@zH2O";

    static String b = "0X-f8k4\"iP";

    static String n = null;

    boolean stringEQ(String a, String b) {
        if (a == b)
            return true;
        if (a == null || b == null)
            return false;
        else
            return a.equals(b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15028().stringEQ(a, b));
    }
}
