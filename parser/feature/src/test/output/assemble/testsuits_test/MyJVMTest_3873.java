public class MyJVMTest_3873 {

    static boolean flag = false;

    boolean test(boolean flag) {
        for (int i = 0; i < 20000; i++) {
            if (flag) {
                int j = 0;
                do {
                    j++;
                } while (j < 10);
            }
        }
        return flag;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3873().test(flag);
    }
}
