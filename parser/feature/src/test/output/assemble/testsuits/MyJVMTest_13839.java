public class MyJVMTest_13839 {

    static String s = "Y,4<'aq+P ";

    int m(String s) {
        return 4321;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13839().m(s));
    }
}
