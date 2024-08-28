public class MyJVMTest_10853 {

    static Baz x = null;

    static int i = 7;

    static String s = "%gw2Rb4meg";

    static int effects = 0;

    Baz iBaz(Baz x) {
        effects++;
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10853().iBaz(x));
    }
}
