public class MyJVMTest_7615 {

    static String a = "dTaK i8wvD";

    static String stringSmallL = "abc";

    String indexOfConstUL(String a) {
        int result = a.indexOf(stringSmallL);
        return a.substring(result, result + stringSmallL.length());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7615().indexOfConstUL(a));
    }
}
