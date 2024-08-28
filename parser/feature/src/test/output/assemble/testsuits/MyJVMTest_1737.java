public class MyJVMTest_1737 {

    static String s = "d.>0/rr}S*";

    String fixNull(String s) {
        if (s == null)
            return "";
        else
            return s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1737().fixNull(s));
    }
}
