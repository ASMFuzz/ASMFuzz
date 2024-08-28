public class MyJVMTest_13685 {

    static String s = "$Gw}1ZJ:KP";

    static String log = "";

    A2 m(String s) {
        log += s;
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13685().m(s));
    }
}
