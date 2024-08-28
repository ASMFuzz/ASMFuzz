public class MyJVMTest_9447 {

    static String msg = "02C6SHOH_t";

    String error(String msg) {
        throw new RuntimeException(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9447().error(msg);
    }
}
