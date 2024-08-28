public class MyJVMTest_4641 {

    static String cmd = "JGT#^e(QDz";

    JdbCommand stepUp() {
        return new JdbCommand("step up");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4641().stepUp());
    }
}
