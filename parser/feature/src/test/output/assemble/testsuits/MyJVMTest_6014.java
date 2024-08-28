public class MyJVMTest_6014 {

    static String s = "L/nKPE^l ,";

    int Test(String s) {
        return s.length();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6014().Test(s));
    }
}
