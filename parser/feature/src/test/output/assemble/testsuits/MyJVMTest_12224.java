public class MyJVMTest_12224 {

    static Object v = 571049100;

    static String s1 = "5V6^B+g25D";

    static String s2 = "bLc%DZ[\"^~";

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
        new MyJVMTest_12224().test(v, s1, s2, flag);
    }
}
