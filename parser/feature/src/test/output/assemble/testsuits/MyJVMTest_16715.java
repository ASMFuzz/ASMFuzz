public class MyJVMTest_16715 {

    static String msg = "hukQ0i`rkp";

    static int passed = 0, failed = 0;

    String success(String msg) {
        passed++;
        System.out.println(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16715().success(msg);
    }
}
