public class MyJVMTest_3953 {

    static String a = "8{l9J08{Tv";

    String concatStringNull(String a) {
        return new StringBuilder().append((String) null).toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3953().concatStringNull(a));
    }
}
