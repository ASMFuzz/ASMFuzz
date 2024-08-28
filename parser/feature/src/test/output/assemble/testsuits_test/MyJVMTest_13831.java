public class MyJVMTest_13831 {

    static String s = "7ItqgjN~\"G";

    String s_string_par_method(String s) {
        return "return";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13831().s_string_par_method(s));
    }
}
