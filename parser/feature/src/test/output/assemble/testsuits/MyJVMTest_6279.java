public class MyJVMTest_6279 {

    static double d1 = 0.9705129250223282;

    static Integer i1 = 3;

    static long l1 = 9223372036854775807L;

    static float f1 = Float.MIN_VALUE;

    static float f2 = Float.MAX_VALUE;

    static float f3 = 0.15779543f;

    static float f4 = Float.NEGATIVE_INFINITY;

    static float f5 = Float.MAX_VALUE;

    static float f6 = Float.MAX_VALUE;

    static float f7 = 0.36485863f;

    static float f8 = Float.MAX_VALUE;

    static float f9 = Float.MIN_VALUE;

    static float f10 = Float.POSITIVE_INFINITY;

    static float f11 = Float.POSITIVE_INFINITY;

    static float f12 = 0f;

    static float f13 = Float.MAX_VALUE;

    boolean testMethod(double d1, Integer i1, long l1, float f1, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        Integer r_i1 = Integer.valueOf(1234);
        double r_d1 = 2863311530.0;
        long r_l1 = 1234567;
        float r_f1 = (float) 1.0000001;
        float r_f2 = (float) 2.0000002;
        float r_f3 = (float) 3.0000003;
        float r_f4 = (float) 4.0000005;
        float r_f5 = (float) 5.0000006;
        float r_f6 = (float) 6.0000007;
        float r_f7 = (float) 7.0000008;
        float r_f8 = (float) 8.0000009;
        float r_f9 = (float) 9.0000011;
        float r_f10 = (float) 10.0000012;
        float r_f11 = (float) 11.0000013;
        float r_f12 = (float) 12.0000014;
        float r_f13 = (float) 13.0000015;
        if ((r_i1.intValue() != i1.intValue()) || (r_d1 != d1) || (r_l1 != l1) || (r_f1 != f1) || (r_f2 != f2) || (r_f3 != f3) || (r_f4 != f4) || (r_f5 != f5) || (r_f6 != f6) || (r_f7 != f7) || (r_f8 != f8) || (r_f9 != f9) || (r_f10 != f10) || (r_f11 != f11) || (r_f12 != f12) || (r_f13 != f13)) {
            System.out.println("\n\nReceived vs Expected " + d1 + "   " + r_d1 + "\n\t int:    " + i1 + "   " + r_i1 + "\n\t long:   1 " + l1 + "   " + r_l1 + "\n\t float:  1 " + f1 + "   " + r_f1 + "\n\t float:  2 " + f2 + "   " + r_f2 + "\n\t float:  3 " + f3 + "   " + r_f3 + "\n\t float:  4 " + f4 + "   " + r_f4 + "\n\t float:  5 " + f5 + "   " + r_f5 + "\n\t float:  6 " + f6 + "   " + r_f6 + "\n\t float:  7 " + f7 + "   " + r_f7 + "\n\t float:  8 " + f8 + "   " + r_f8 + "\n\t float:  9 " + f9 + "   " + r_f9 + "\n\t float: 10 " + f10 + "   " + r_f10 + "\n\t float: 11 " + f11 + "   " + r_f11 + "\n\t float: 12 " + f12 + "   " + r_f12 + "\n\t float: 13 " + f13 + "   " + r_f13 + "\n");
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6279().testMethod(d1, i1, l1, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13));
    }
}
