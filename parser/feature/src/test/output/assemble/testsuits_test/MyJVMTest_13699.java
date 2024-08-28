public class MyJVMTest_13699 {

    static int i = 8;

    static int j = 0;

    static MyException myex = new MyException();

    Object test_helper(int i, int j) {
        Object res = null;
        try {
            if (i < 10) {
                throw myex;
            }
            if (i == 14) {
            }
            if (i > 15) {
                throw myex;
            }
        } catch (MyException e) {
            if (j == 0x42) {
                res = new A();
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13699().test_helper(i, j));
    }
}
