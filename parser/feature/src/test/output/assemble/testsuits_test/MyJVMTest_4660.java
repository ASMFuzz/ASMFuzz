public class MyJVMTest_4660 {

    static String str = "3z9Dh#7o$A";

    String stringmakerBUG(String str) {
        try {
            return new StringBuffer(str).toString();
        } catch (NullPointerException e) {
            return "NPE";
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4660().stringmakerBUG(str));
    }
}
