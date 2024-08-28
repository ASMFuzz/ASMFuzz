public class MyJVMTest_12800 {

    static String a = "Upv:=D<P^i";

    static String emptyString = "";

    String indexOfConstEmptyU(String a) {
        int result = a.indexOf(emptyString);
        return a.substring(result, result + emptyString.length());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12800().indexOfConstEmptyU(a));
    }
}
