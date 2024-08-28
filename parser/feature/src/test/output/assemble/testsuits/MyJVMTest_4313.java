public class MyJVMTest_4313 {

    static String s = "%OHnB;JLlB";

    static String log = "";

    A2 m(String s) {
        log += s;
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4313().m(s));
    }
}
