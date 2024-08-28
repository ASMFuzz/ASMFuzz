public class MyJVMTest_11715 {

    static String what = "f^qG81}C6?";

    static String cmd = "BDr|?GO@%d";

    JdbCommand dump(String what) {
        return new JdbCommand("dump " + what);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11715().dump(what));
    }
}
