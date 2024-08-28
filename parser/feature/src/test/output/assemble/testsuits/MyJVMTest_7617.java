public class MyJVMTest_7617 {

    static String a = "O*#<Y&3k6r";

    static String b = "\\Jn-4PlvmV";

    String overloaded(final String a, final String b) {
        return "overloaded(String, String)";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7617().overloaded(a, b));
    }
}
