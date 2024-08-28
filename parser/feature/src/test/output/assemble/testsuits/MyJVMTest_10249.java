public class MyJVMTest_10249 {

    static Bar x = null;

    static int i = 7;

    static String s = "j=\\z8fdCF(";

    static int effects = 0;

    Bar iBar(Bar x) {
        effects++;
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10249().iBar(x));
    }
}
