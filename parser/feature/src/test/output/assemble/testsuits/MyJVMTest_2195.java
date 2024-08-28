public class MyJVMTest_2195 {

    static String text = "Rh}<f_NlW{";

    static int i = 0;

    static char elem = 'P';

    static char val = Character.MAX_VALUE;

    int verify(String text, int i, char elem, char val) {
        if (elem != val) {
            System.err.println(text + "[" + i + "] = " + elem + " != " + val);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2195().verify(text, i, elem, val));
    }
}
