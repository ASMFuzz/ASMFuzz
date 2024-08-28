public class MyJVMTest_3469 {

    static String a = "%T'$F`~!~{";

    static String emptyString = "";

    String indexOfConstEmptyU(String a) {
        int result = a.indexOf(emptyString);
        return a.substring(result, result + emptyString.length());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3469().indexOfConstEmptyU(a));
    }
}
