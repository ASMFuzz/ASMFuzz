public class MyJVMTest_8801 {

    static double a = 0d;

    static double b = 0.8944090899009806;

    double add_opt_double(double a, double b) {
        return Math.max(a, b) + Math.min(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8801().add_opt_double(a, b));
    }
}
