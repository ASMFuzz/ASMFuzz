public class MyJVMTest_5486 {

    static double X = java.lang.Math.PI;

    static boolean b = false;

    double getX() {
        return X;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5486().getX());
    }
}
