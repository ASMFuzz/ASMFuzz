public class MyJVMTest_3068 {

    static String a = "XR<x#\"{43j";

    String concatString(String a) {
        return new StringBuilder().append(a).toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3068().concatString(a));
    }
}
