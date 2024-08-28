public class MyJVMTest_2574 {

    static String message = ":<kGo&6{5\\";

    String Fail(String message) {
        System.out.println(message);
        System.exit(100);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2574().Fail(message);
    }
}
