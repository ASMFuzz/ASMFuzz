public class MyJVMTest_10469 {

    static String a = "9B;%.@Y]R=";

    static String stringSmallU = "\u0f21\u0f22\u0f23";

    String indexOfConstU(String a) {
        int result = a.indexOf(stringSmallU);
        return a.substring(result, result + stringSmallU.length());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10469().indexOfConstU(a));
    }
}
