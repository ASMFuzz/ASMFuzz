public class MyJVMTest_6805 {

    static int arg = 7;

    Object test1(int arg) {
        Object[] arr = new Object[3];
        int lim = (arg & 3);
        for (int i = 0; i < lim; ++i) {
            arr[i] = new Object();
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6805().test1(arg));
    }
}
