public class MyJVMTest_15469 {

    static String s = "z4)q q|mbp";

    int Test(String s) {
        return s.length();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15469().Test(s));
    }
}
