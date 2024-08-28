public class MyJVMTest_10480 {

    static Object obj = 925652558;

    static boolean loop = true;

    Object test(Object obj) {
        for (int i = 0; i == 0; ) {
            while (true) {
                int val = (Integer) obj;
                if (val == i++)
                    break;
                if (!loop)
                    break;
            }
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10480().test(obj);
    }
}
