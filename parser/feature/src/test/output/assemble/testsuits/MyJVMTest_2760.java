public class MyJVMTest_2760 {

    static String msg = ")DZ%b.MKu+";

    static Throwable tble = new Throwable();

    String error(String msg, Throwable tble) {
        String finalMsg = "FAILED " + (msg != null ? msg : "");
        if (tble != null) {
            throw new RuntimeException(finalMsg, tble);
        }
        throw new RuntimeException(finalMsg);
        return finalMsg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2760().error(msg, tble);
    }
}
