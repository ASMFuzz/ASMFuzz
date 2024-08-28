public class MyJVMTest_5976 {

    static int i = 1509699079;

    static int limit5 = Integer.MIN_VALUE + 10000;

    int test5(int i) {
        int result = 0;
        while (i++ != limit5) {
            result = i * 2;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5976().test5(i));
    }
}
