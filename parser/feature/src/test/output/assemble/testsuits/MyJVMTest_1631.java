public class MyJVMTest_1631 {

    static Baz x = null;

    static int i = 3;

    static String s = "t\\3e$2`Mgi";

    static int effects = 0;

    Baz iBaz(Baz x) {
        effects++;
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1631().iBaz(x));
    }
}
