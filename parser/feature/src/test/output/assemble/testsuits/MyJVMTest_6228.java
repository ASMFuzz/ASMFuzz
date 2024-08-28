public class MyJVMTest_6228 {

    static String mesg = "(=r,M34S%C";

    String error(String mesg) {
        throw new RuntimeException(mesg);
        return mesg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6228().error(mesg);
    }
}
