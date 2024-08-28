public class MyJVMTest_11388 {

    static String s = "8mOcURlj{g";

    static Number args = null;

    int f(String s, Number... args) {
        return 4;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11388().f(s, args));
    }
}
