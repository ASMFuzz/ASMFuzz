public class MyJVMTest_6160 {

    static String a = "iD_BOR$sCj";

    String concatStringEmpty(String a) {
        return new StringBuilder().toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6160().concatStringEmpty(a));
    }
}
