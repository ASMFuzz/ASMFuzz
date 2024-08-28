public class MyJVMTest_2448 {

    static String what = "xduw)fhA?>";

    static String cmd = "-*=(ydGv\"}";

    JdbCommand dump(String what) {
        return new JdbCommand("dump " + what);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2448().dump(what));
    }
}
