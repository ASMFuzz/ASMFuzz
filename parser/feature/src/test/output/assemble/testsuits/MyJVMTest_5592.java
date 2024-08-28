public class MyJVMTest_5592 {

    static String a = "zcZVM;8,c<";

    static String b = "%cQDg*tWAM";

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
        System.out.println(new MyJVMTest_5592().stringEQ(a, b));
    }
}
