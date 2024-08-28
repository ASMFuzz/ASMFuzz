public class MyJVMTest_13340 {

    static String s = "TdzT)K|RDf";

    String str(String s) {
        return (s == null ? "null" : '"' + s + '"');
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13340().str(s));
    }
}
