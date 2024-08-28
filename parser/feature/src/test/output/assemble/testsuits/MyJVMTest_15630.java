public class MyJVMTest_15630 {

    static String a = "O{`tq25&Qt";

    String concatStringEmpty(String a) {
        return new StringBuilder().toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15630().concatStringEmpty(a));
    }
}
