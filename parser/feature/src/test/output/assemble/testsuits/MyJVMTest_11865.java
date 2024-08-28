public class MyJVMTest_11865 {

    static String msg = "rYZ`P<7goZ";

    static String testName = "C8`0Oo}5Js";

    static int passed = 0, failed = 0;

    String success(String msg) {
        passed++;
        System.out.println(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11865().success(msg);
    }
}
