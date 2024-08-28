public class MyJVMTest_12563 {

    static double u = Double.MIN_VALUE;

    static boolean b = false;

    double getProp() {
        return 0.;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12563().getProp());
    }
}
