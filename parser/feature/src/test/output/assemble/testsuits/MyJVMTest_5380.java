public class MyJVMTest_5380 {

    static String msg = "|~kumX~N'%";

    String log(String msg) {
        System.out.println(msg);
        System.out.flush();
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5380().log(msg);
    }
}
