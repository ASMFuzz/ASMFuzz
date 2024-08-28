public class MyJVMTest_1256 {

    static int arg = 1064821475;

    static int value = 4;

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
        System.out.println(new MyJVMTest_1256().test2(arg, value));
    }
}
