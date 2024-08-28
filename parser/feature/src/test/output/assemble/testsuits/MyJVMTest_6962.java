public class MyJVMTest_6962 {

    static String in = "@jgo4brBN[";

    String getString(String in) {
        if (in.equals("id"))
            return "idFoo";
        if (in.equals("contentKey"))
            return "ckFoo";
        return "Foo";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6962().getString(in));
    }
}
