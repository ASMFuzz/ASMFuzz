public class MyJVMTest_10266 {

    static String why = "9+HNn{cr<m";

    static String input = "r$)S@eMqU~";

    static int limit = 0;

    String fail(String why) throws Exception {
        throw new Exception(why);
        return why;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10266().fail(why);
    }
}
