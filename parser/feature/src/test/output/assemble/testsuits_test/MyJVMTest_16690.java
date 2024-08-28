public class MyJVMTest_16690 {

    static Object[] array = { 0, 0, 9, 0, 7, 6, 3, 1, 8, 396541620 };

    static Object objectField = 2;

    Object test(Object[] array) {
        Object o = objectField;
        Object o3 = array[1];
        int j = 0;
        for (int i = 1; i < 100; i *= 2) {
            Object o2 = array[i];
            if (o3 != null) {
                if (o2 == null) {
                }
                if (o != null) {
                    if (o.getClass() == Object.class) {
                    }
                    if (j > 7) {
                    }
                    j++;
                }
            }
        }
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16690().test(array);
    }
}
