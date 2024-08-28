public class MyJVMTest_5616 {

    static String a = "UFis<%Y#3+";

    static String stringU = "\u0f21\u0f22\u0f23\u0f24\u0f25\u0f26\u0f27\u0f28";

    String indexOfConstLargeU(String a) {
        int result = a.indexOf(stringU);
        return a.substring(result, result + stringU.length());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5616().indexOfConstLargeU(a));
    }
}
