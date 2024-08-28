public class MyJVMTest_14051 {

    static String str = "J#0nc0E01r";

    String stringmakerBUG(String str) {
        try {
            return new StringBuffer(str).toString();
        } catch (NullPointerException e) {
            return "NPE";
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14051().stringmakerBUG(str));
    }
}
