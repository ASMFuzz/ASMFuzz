public class MyJVMTest_11033 {

    static String s = "F&>>--U:Mv";

    String bar(String s) {
        return "MethodRef1.bar(String) " + s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11033().bar(s));
    }
}
