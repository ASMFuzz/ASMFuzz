public class MyJVMTest_13302 {

    static String a = "8w\\Li,V;c(";

    String concatStringNull(String a) {
        return new StringBuilder().append((String) null).toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13302().concatStringNull(a));
    }
}
