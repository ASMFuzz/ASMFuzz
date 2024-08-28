public class MyJVMTest_1808 {

    static String s = "oQ.@e7/3A+";

    String bar(String s) {
        return "MethodRef1.bar(String) " + s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1808().bar(s));
    }
}
