public class MyJVMTest_7192 {

    static String msg = "Yjkl}%oHQ_";

    static int passed = 0, failed = 0;

    String success(String msg) {
        passed++;
        System.out.println(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7192().success(msg);
    }
}
