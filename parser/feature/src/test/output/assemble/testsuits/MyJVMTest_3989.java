public class MyJVMTest_3989 {

    static String s = "hR'Tuux[Y9";

    String str(String s) {
        return (s == null ? "null" : '"' + s + '"');
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3989().str(s));
    }
}
