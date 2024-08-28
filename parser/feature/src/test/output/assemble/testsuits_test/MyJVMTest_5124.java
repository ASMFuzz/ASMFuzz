public class MyJVMTest_5124 {

    static String s = "f{@cEWixdw";

    String write(String s) {
        System.out.println(s);
        System.out.flush();
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5124().write(s);
    }
}
