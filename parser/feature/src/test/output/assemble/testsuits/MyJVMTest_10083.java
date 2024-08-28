public class MyJVMTest_10083 {

    static double x = Double.MAX_VALUE;

    double earth(double x) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10083().earth(x));
    }
}
