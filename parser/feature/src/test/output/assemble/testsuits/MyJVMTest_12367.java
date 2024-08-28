public class MyJVMTest_12367 {

    static int dummy = 0;

    static int X = javax.swing.SwingConstants.TOP;

    static boolean b = true;

    int getX(int... dummy) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12367().getX(dummy));
    }
}
