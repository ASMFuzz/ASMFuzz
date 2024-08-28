public class MyJVMTest_15701 {

    static String mesg = "4qg_:(~yoE";

    String error(String mesg) {
        throw new RuntimeException(mesg);
        return mesg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15701().error(mesg);
    }
}
