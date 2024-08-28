public class MyJVMTest_11285 {

    static String s = ")-?xx<J/jY";

    static int a = 0;

    static int b = 0;

    int f(String s, int a, int b) {
        return 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11285().f(s, a, b));
    }
}
