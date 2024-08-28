public class MyJVMTest_14805 {

    static String msg = "x4MZ(c6{5O";

    String log(String msg) {
        System.out.println(msg);
        System.out.flush();
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14805().log(msg);
    }
}
