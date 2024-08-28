public class MyJVMTest_7167 {

    static Object[] array = { 368023395, 1742566325, 6, 0, 1, 663104410, 7, 1, 8, 0 };

    static Object objectField = 4;

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
        new MyJVMTest_7167().test(array);
    }
}
