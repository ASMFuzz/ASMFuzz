public class MyJVMTest_295 {

    static String msg = "YJ`BRmW64A";

    String error(String msg) {
        throw new RuntimeException(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_295().error(msg);
    }
}
