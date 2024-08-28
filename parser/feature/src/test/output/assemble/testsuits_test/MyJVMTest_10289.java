public class MyJVMTest_10289 {

    static String a = "<kN2:~(?|*";

    static String emptyString = "";

    String indexOfConstEmptyL(String a) {
        int result = a.indexOf(emptyString);
        return a.substring(result, result + emptyString.length());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10289().indexOfConstEmptyL(a));
    }
}
