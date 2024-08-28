public class MyJVMTest_17163 {

    static String a = "FPhWuj;51R";

    static String b = "D?2c*5FJ`f";

    String overloaded(final String a, final String b) {
        return "overloaded(String, String)";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17163().overloaded(a, b));
    }
}
