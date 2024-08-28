public class MyJVMTest_16822 {

    static double X = java.lang.Math.PI;

    static double u = 0.9288641428229335;

    static boolean b = false;

    double getX() {
        return X;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16822().getX());
    }
}
