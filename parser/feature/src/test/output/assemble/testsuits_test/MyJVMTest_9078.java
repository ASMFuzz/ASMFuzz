public class MyJVMTest_9078 {

    static String s = "de6=7CO6yI";

    String str(String s) {
        return (s == null ? "null" : '"' + s + '"');
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9078().str(s));
    }
}
