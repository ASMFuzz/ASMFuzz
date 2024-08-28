public class MyJVMTest_1094 {

    static String a = "|]IFdDBPp1";

    static String emptyString = "";

    String indexOfConstEmptyL(String a) {
        int result = a.indexOf(emptyString);
        return a.substring(result, result + emptyString.length());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1094().indexOfConstEmptyL(a));
    }
}
