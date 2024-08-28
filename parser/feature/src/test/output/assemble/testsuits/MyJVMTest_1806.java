public class MyJVMTest_1806 {

    static String[] o = { "}mh>(p\"54q", "'\"q*H%M'mB", "dT>,K-n4e@", "/_yb;%W,qb", "\\W99\\owcS[", "$uhB+L_>`C", "6DwIdQh*10", "emL'<ACX(l", "9cjajwo*eh", "}&51,.;Q`k" };

    static int nonStaticPublicField = 9;

    int getLength(String[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1806().getLength(o));
    }
}
