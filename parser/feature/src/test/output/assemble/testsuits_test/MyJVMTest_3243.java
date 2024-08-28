public class MyJVMTest_3243 {

    static double u = Double.MIN_VALUE;

    static boolean b = false;

    double getProp() {
        return 0.;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3243().getProp());
    }
}
