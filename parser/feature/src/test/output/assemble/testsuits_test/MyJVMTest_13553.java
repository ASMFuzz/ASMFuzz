public class MyJVMTest_13553 {

    static int arg = 6;

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

    boolean test3(int arg) {
        int i;
        for (i = 0; i < 1; ++i) {
        }
        return test2(arg, i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13553().test3(arg));
    }
}
