public class MyJVMTest_14916 {

    static double X = java.lang.Math.PI;

    static boolean b = true;

    double getX() {
        return X;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14916().getX());
    }
}
