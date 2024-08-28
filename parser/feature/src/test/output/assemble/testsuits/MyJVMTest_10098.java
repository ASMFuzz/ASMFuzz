public class MyJVMTest_10098 {

    static String msg = "#'PcgJbHy=";

    String fail(String msg) {
        System.err.println(msg);
        java.lang.System.exit(1);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10098().fail(msg);
    }
}
