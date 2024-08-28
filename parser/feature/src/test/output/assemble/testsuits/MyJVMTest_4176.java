public class MyJVMTest_4176 {

    static double v = 0d;

    static double x = 0d;

    double setX(double v) {
        x = -v;
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4176().setX(v);
    }
}
