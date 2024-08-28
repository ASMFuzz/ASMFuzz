public class MyJVMTest_2519 {

    static int arg = 9;

    Object test(int arg) {
        Object[] arr = new Object[3];
        int lim = (arg & 3);
        for (int i = 0; i < lim; ++i) {
            arr[i] = new Object();
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2519().test(arg));
    }
}
