public class MyJVMTest_10960 {

    static String s = ")HU(`A-gB?";

    String fixNull(String s) {
        if (s == null)
            return "";
        else
            return s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10960().fixNull(s));
    }
}
