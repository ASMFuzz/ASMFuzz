public class MyJVMTest_15999 {

    static boolean x = false;

    static String w = "CE>4!f'.'G";

    String inspect(final boolean x, final String w) {
        return w + ": boolean";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15999().inspect(x, w));
    }
}
