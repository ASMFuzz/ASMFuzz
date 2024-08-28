public class MyJVMTest_16473 {

    static String in = "\\znc!*E5\"k";

    String getString(String in) {
        if (in.equals("id"))
            return "idFoo";
        if (in.equals("contentKey"))
            return "ckFoo";
        return "Foo";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16473().getString(in));
    }
}
