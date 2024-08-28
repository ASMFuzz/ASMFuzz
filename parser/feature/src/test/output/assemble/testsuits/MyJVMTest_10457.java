public class MyJVMTest_10457 {

    static int arg = 0;

    static int value = 2116783165;

    boolean test2(int arg, int value) {
        if (arg < 0) {
            if (value > 0) {
                return false;
            }
        } else if (arg > 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10457().test2(arg, value));
    }
}
