public class MyJVMTest_2924 {

    static Object v = 4;

    static String s1 = "U.s]<^b)0(";

    static String s2 = "9g!6ptv5Ir";

    static boolean flag = true;

    Object test(Object v, String s1, String s2, boolean flag) {
        if (flag) {
            return;
        }
        int i = 0;
        for (; i < 10; i++) ;
        if (i == 10) {
            v = null;
        }
        StringBuilder sb = new StringBuilder(s1);
        sb.append(s2);
        while (v == null) ;
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2924().test(v, s1, s2, flag);
    }
}
