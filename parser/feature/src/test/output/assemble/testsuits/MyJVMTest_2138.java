public class MyJVMTest_2138 {

    static String s = "iM>1xV'?nu";

    static Number args = null;

    int f(String s, Number... args) {
        return 4;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2138().f(s, args));
    }
}
